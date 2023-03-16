package com.rezaalamsyah.core.utils

import android.content.Context
import android.view.View
import android.widget.Toast
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import com.google.android.play.core.splitinstall.SplitInstallRequest

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun Context.installModule(
    moduleName: String,
    onSuccess: () -> Unit,
    onFailure: () -> Unit,
) {
    val splitInstallManager = SplitInstallManagerFactory.create(this)
    if (splitInstallManager.installedModules.contains(moduleName)) {
        onSuccess.invoke()
    } else {
        val request = SplitInstallRequest.newBuilder()
            .addModule(moduleName)
            .build()
        splitInstallManager.startInstall(request)
            .addOnSuccessListener {
                Toast.makeText(this, "Module Installed", Toast.LENGTH_SHORT).show()
                onSuccess.invoke()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Error on Installing Module or Module Not Available", Toast.LENGTH_SHORT).show()
                onFailure.invoke()
            }
    }
}