package com.dropit.ambassador.core.di.viewmodel

import androidx.lifecycle.ViewModel
import com.dropit.ambassador.core.AndroidComponent
import dagger.MapKey
import kotlin.reflect.KClass

@Target(
	AnnotationTarget.FUNCTION,
	AnnotationTarget.PROPERTY_GETTER,
	AnnotationTarget.PROPERTY_SETTER
)

@Retention(AnnotationRetention.RUNTIME)
@MapKey(unwrapValue = false)
annotation class ViewModelKey(val kClass: KClass<out AndroidComponent>, val viewModel: KClass<out ViewModel>)