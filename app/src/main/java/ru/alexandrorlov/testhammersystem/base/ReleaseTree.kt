package ru.alexandrorlov.testhammersystem.base

import timber.log.Timber

object ReleaseTree : Timber.Tree() {

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        return
    }

}