package com.benmohammad.moremvi.presentation.common

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.benmohammad.moremvi.R
import com.benmohammad.moremvi.data.common.CallErrors
import kotlin.reflect.KClass

fun<T: ViewModel> RootBaseActivity.viewModelProvider(
    factory: ViewModelProvider.Factory,
    model: KClass<T>
): T {
    return androidx.lifecycle.ViewModelProvider(this, factory).get(model.java)
}

fun Boolean.runIfTrue(block: () -> Unit) {
    if(this) {
        block()
    }
}

fun CallErrors.getMessage(context: Context):String {
    return when(this) {
        is CallErrors.ErrorEmptyData  -> context.getString(R.string.error_empty_data)
        is CallErrors.ErrorServer -> context.getString(R.string.error_server_error)
        is CallErrors.ErrorException -> context.getString(R.string.error_exception)
    }
}