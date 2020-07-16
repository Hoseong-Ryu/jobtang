package com.example.retrofitexampleretry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.retrofitexampleretry.retrofit.RetrofitHelper
import com.example.retrofitexampleretry.retrofit.domain.Employee
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val retrofitHelper = RetrofitHelper.getServiceApi()

    private val mCompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //okHttpEmployee()
        rxEmployee()
    }

    private fun okHttpEmployee() {
        retrofitHelper.getOkHttpEmployees()
                .enqueue(object: Callback<Employee>{
                    override fun onResponse(call: Call<Employee>, response: Response<Employee>) {

                        val data = response.body()?.data
                        var str = ""

                        for(i in 0 until data!!.size) {
                            str += data[i].employee_name + "\n"

                            Log.d("test", data[i].employee_name)
                        }

                        employee.text = str
                    }

                    override fun onFailure(call: Call<Employee>, t: Throwable) {}

                })
    }

    override fun onDestroy() {
        super.onDestroy()
        mCompositeDisposable.dispose()
    }

    private fun rxEmployee() {

        mCompositeDisposable.add(
                retrofitHelper.getRxEmployees()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(object: DisposableObserver<Employee>(){
                            override fun onNext(_employee: Employee) {
                                var str = ""

                                for(i in 0 until _employee.data!!.size) {
                                    str += _employee.data[i].employee_name + "\n"

                                    Log.d("test", _employee.data[i].employee_name)
                                }

                                employee.text = str
                            }

                            override fun onComplete() {}

                            override fun onError(e: Throwable) {}
                        })
        )
    }
}