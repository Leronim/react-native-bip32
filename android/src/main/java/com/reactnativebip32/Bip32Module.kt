package com.reactnativebip32

import android.util.Log
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.module.annotations.ReactModule
import io.github.novacrypto.bip32.ExtendedPrivateKey
import io.github.novacrypto.bip32.ExtendedPublicKey
import io.github.novacrypto.bip32.Network
import io.github.novacrypto.bip32.networks.Bitcoin


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
  fun sign(seed: String, network: Network, path: String?): ExtendedPublicKey? {
    Log.d("TEST", "${seed}")
    val seedByte = seed.toByteArray()

    val key = ExtendedPrivateKey.fromSeed(seedByte, network)
    val child = key.derive("m/0'/0")
    val childPub = child.neuter()

    return childPub
  }
}
