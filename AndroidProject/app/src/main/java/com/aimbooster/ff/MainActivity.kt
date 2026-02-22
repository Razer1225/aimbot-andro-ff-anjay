package com.aimbooster.ff

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.aimbooster.ff.fragments.AboutFragment
import com.aimbooster.ff.fragments.BoostAimFragment
import com.aimbooster.ff.fragments.EnhancedAimFragment
import com.aimbooster.ff.fragments.HomeFragment
import com.aimbooster.ff.fragments.SensitivityFragment

class MainActivity : AppCompatActivity() {

    private lateinit var btnBack: ImageButton
    private lateinit var ivLogo: ImageView
    private lateinit var tvTitle: TextView
    private lateinit var tvTagline: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnBack = findViewById(R.id.btnBack)
        ivLogo = findViewById(R.id.ivLogo)
        tvTitle = findViewById(R.id.tvTitle)
        tvTagline = findViewById(R.id.tvTagline)

        btnBack.setOnClickListener { onBackPressedDispatcher.onBackPressed() }

        supportFragmentManager.addOnBackStackChangedListener {
            val current = supportFragmentManager.findFragmentById(R.id.fragmentContainer)
            val isHome = current is HomeFragment
            showHeaderMode(!isHome, current ?: HomeFragment())
        }

        if (savedInstanceState == null) {
            showFragment(HomeFragment(), false)
        }
    }

    fun showFragment(fragment: Fragment, showBack: Boolean) {
        showHeaderMode(showBack, fragment)
        val transaction = supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
        if (showBack) {
            transaction.addToBackStack(null)
        }
        transaction.commit()
    }

    fun setScreenTitle(title: String) {
        tvTitle.text = title
    }

    private fun showHeaderMode(showBack: Boolean, fragment: Fragment?) {
        if (showBack && fragment != null) {
            btnBack.visibility = View.VISIBLE
            ivLogo.visibility = View.GONE
            tvTagline.visibility = View.GONE
            tvTitle.text = when (fragment) {
                is EnhancedAimFragment -> getString(R.string.enhanced_aim)
                is BoostAimFragment -> getString(R.string.boost_aim)
                is SensitivityFragment -> getString(R.string.sensitivity_settings)
                is AboutFragment -> getString(R.string.about_device)
                else -> getString(R.string.app_name)
            }
        } else {
            btnBack.visibility = View.GONE
            ivLogo.visibility = View.VISIBLE
            tvTagline.visibility = View.VISIBLE
            tvTitle.text = getString(R.string.app_name)
        }
    }
}
