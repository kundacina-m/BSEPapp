package com.dropit.ambassador.core.presentation

import androidx.annotation.NonNull
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.dropit.ambassador.core.presentation.viewmodel.ObservableSingleEvent

/**
 * Created by novemio on 8/29/19.
 */
abstract class BaseActions<Action> {
	protected val action = ObservableSingleEvent<Action>()

	fun observeBy(@NonNull owner: LifecycleOwner, block: (Action) -> Unit) {
		action.observe(owner, Observer { block(it) })
	}

}