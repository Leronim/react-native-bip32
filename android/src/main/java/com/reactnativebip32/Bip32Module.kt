package com.reactnativebip32

import android.net.Network
import android.text.TextUtils
import android.util.Log
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.module.annotations.ReactModule
import com.reactnativebip32.Bip32Module

@ReactModule(name = Bip32Module.NAME)
class Bip32Module(reactContext: ReactApplicationContext?) : ReactContextBaseJavaModule(reactContext) {
  override fun getName(): String {
    return NAME
  }

  companion object {
    const val NAME = "Bip32"

    init {
      try {
        // Used to load the 'native-lib' library on application startup.
        System.loadLibrary("cpp")
      } catch (ignored: Exception) {
      }
    }
  }

  fun getHardenedPath(path: String): String {
    val t: ArrayList<String?> = ArrayList();
    val splitPath = path.split("/").toTypedArray()
    for (i in 0..splitPath.size) {
      if (splitPath[i] == "m" || splitPath[i].indexOf("'") != -1) {
        t.add(splitPath[i]);
      }
    }
    return t.joinToString(separator = "/")
  }

  // Example method
  // See https://reactnative.dev/docs/native-modules-android
  @ReactMethod
  fun sign(seed: String, network: String, path: String?): String {
    Log.d("TEST", "${seed}")
    val seedByte = seed.toByteArray()
    Log.d("TEST", "${seedByte}")
    //        ExtendedPrivateKey key = ExtendedPrivateKey.fromSeed(seedByte, network);

    return "1243";
  }
}
