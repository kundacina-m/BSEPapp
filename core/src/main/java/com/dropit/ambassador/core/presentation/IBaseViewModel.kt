package com.dropit.ambassador.core.presentation

import com.dropit.ambassador.core.domain.BaseInteractor
import com.dropit.ambassador.core.domain.BaseInteractorFlowable
import com.dropit.ambassador.core.domain.BaseInteractorObservable
import com.dropit.ambassador.core.domain.BaseInteractorSingle
import com.dropit.ambassador.core.utils.result.SealedResult

interface IBaseViewModel {

    val interactors: MutableSet<BaseInteractor>

    fun clearInteractors(){
        interactors.forEach { it.clearDisposables() }
    }

    fun <P, R> BaseInteractorSingle<P, R>.executeBy(params: P, result: (SealedResult<R>) -> Unit) {
        interactors.add(this)
        this.execute(params, result)
    }

    fun <P, R> BaseInteractorFlowable<P, R>.executeBy(
        params: P,
        result: (SealedResult<R>) -> Unit
    ) {
        interactors.add(this)
        this.execute(params, result)
    }

    fun <P, R> BaseInteractorObservable<P, R>.executeBy(
        params: P,
        result: (SealedResult<R>) -> Unit
    ) {
        interactors.add(this)
        this.execute(params, result)
    }
}