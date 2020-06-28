package com.dropit.ambassador.core.presentation

/**
 * Helper class for providing databinding id for ViewModel (BR.vm).
 */
object ViewModelIdProvider {

    var viewModelId: Int? = null
        get() = field ?: throw IllegalArgumentException("ViewModelIdProvider not initialized")

}
