package com.dropit.ambassador.core.presentation

import androidx.lifecycle.ViewModel
import com.dropit.ambassador.core.domain.BaseInteractor

abstract class BaseViewModel : ViewModel(), IBaseViewModel {

	override val interactors: MutableSet<BaseInteractor> by lazy {
		mutableSetOf<BaseInteractor>()
	}

	override fun onCleared() {
		super.onCleared()
		clearInteractors()
	}

}