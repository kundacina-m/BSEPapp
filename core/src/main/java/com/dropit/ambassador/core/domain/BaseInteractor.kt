package com.dropit.ambassador.core.domain

import io.reactivex.disposables.CompositeDisposable

/**
 * Created by novemio on 7/10/19.
 */
abstract class BaseInteractor : IDisposable {

    override val compositeDisposable by lazy { CompositeDisposable() }

}