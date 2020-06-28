package com.dropit.ambassador.core.utils

import android.util.Log
import com.dropit.ambassador.core.utils.result.RequestErrorParser
import com.dropit.ambassador.core.utils.result.SealedResult
import com.dropit.ambassador.core.utils.result.SealedResult.OnError
import com.dropit.ambassador.core.utils.result.SealedResult.OnSuccess
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single

// Mapping "Flowable type" incoming data or error to my Result
fun <T> Flowable<T>.validate(): Flowable<SealedResult<T>> {

	return this.map<SealedResult<T>> { OnSuccess(it) }
		.onErrorReturn {
			Log.i("VALIDATE:", "Error $it")
			OnError(RequestErrorParser.parse(exception = it))
		}
}

fun <T> Single<T>.validate(): Single<SealedResult<T>> {

	return this.map<SealedResult<T>> { OnSuccess(it) }
		.onErrorReturn {
			Log.i("VALIDATE:", "Error $it")
			OnError(RequestErrorParser.parse(exception = it))
		}
}

// Mapping "Observable type" incoming data or error to my Result
fun <T> Observable<T>.validate(): Observable<SealedResult<T>> {

	return this.map<SealedResult<T>> { OnSuccess(it) }
		.onErrorReturn {
			Log.i("VALIDATE:", "Error $it")
			OnError(RequestErrorParser.parse(exception = it))
		}
}

//		("#,###.00")