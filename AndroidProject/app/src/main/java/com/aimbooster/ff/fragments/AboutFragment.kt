package com.aimbooster.ff.fragments

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.os.StatFs
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.aimbooster.ff.BuildConfig
import com.aimbooster.ff.R
import java.io.File

class AboutFragment : Fragment() {

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.tvDeviceModelValue).text =
            Build.MANUFACTURER + " " + Build.MODEL

        view.findViewById<TextView>(R.id.tvAndroidVersion).text =
            "Android " + Build.VERSION.RELEASE + " (API " + Build.VERSION.SDK_INT + ")"

        view.findViewById<TextView>(R.id.tvAppVersion).text =
            "Aim Booster FF v" + BuildConfig.VERSION_NAME + " (Build " + BuildConfig.VERSION_CODE + ")"

        view.findViewById<TextView>(R.id.tvProcessor).text =
            Build.HARDWARE + " / " + Build.SUPPORTED_ABIS.joinToString(", ")

        val runtime = Runtime.getRuntime()
        val usedRam = (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024)
        val maxRam = runtime.maxMemory() / (1024 * 1024)
        view.findViewById<TextView>(R.id.tvRam).text = "App: $usedRam MB / Max heap: $maxRam MB"

        val path = Environment.getDataDirectory()
        val stat = StatFs(path.path)
        val blockSize = stat.blockSizeLong
        val totalBlocks = stat.blockCountLong
        val availableBlocks = stat.availableBlocksLong
        val totalStorage = (totalBlocks * blockSize) / (1024 * 1024 * 1024)
        val freeStorage = (availableBlocks * blockSize) / (1024 * 1024 * 1024)
        val usedStorage = totalStorage - freeStorage
        view.findViewById<TextView>(R.id.tvStorage).text = "$usedStorage GB used / $totalStorage GB total"
    }
}
