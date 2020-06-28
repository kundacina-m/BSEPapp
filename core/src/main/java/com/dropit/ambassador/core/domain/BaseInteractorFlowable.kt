package com.dropit.ambassador.core.domain

import com.dropit.ambassador.core.utils.result.SealedResult
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy

/**
 * Created by novemio on 7/10/19.
 */
abstract class BaseInteractorFlowable<Params, Result> : BaseInteractor() {

	abstract fun buildExecute(params: Params): Flowable<SealedResult<Result>>

	fun execute(params: Params) = Mapper(params)

	fun execute(params: Params, result: (SealedResult<Result>) -> Unit) {
		buildExecute(params).subscribeDispose {
			result(it)
		}
	}

	inner class Mapper(private val params: Params) {

		fun <M> map(mapper: (Result) -> M, result: (SealedResult<M>) -> Unit) {
			buildExecute(params).map { sealedResult -> sealedResult.map { mapper(it) } }
				.subscribeDispose {
					result(it)
				}
		}
	}


}

