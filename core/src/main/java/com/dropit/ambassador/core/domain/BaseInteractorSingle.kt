package com.dropit.ambassador.core.domain

import com.dropit.ambassador.core.utils.result.SealedResult
import com.dropit.ambassador.core.utils.result.SingleResult
import io.reactivex.Single
import io.reactivex.rxkotlin.subscribeBy

/**
 * Created by novemio on 7/10/19.
 */

abstract class BaseInteractorSingle<Params, Result> : BaseInteractor() {

	protected abstract fun buildExecute(params: Params): SingleResult<Result>

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

