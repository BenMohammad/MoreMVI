package com.benmohammad.moremvi.presentation.di.common

import com.benmohammad.moremvi.presentation.common.RootBaseActivity
import com.benmohammad.moremvi.presentation.di.annotations.ActivityScope
import javax.inject.Inject

@ActivityScope
class AppRouter @Inject constructor(private val activity: RootBaseActivity) {
}