package org.odk.collect.android.errors

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.odk.collect.android.R
import org.odk.collect.android.activities.CollectAbstractActivity
import org.odk.collect.strings.localization.getLocalizedString

class ErrorActivity : CollectAbstractActivity() {
    companion object {
        const val EXTRA_ERRORS = "ERRORS"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_error)
        initToolbar(getLocalizedString(R.string.errors))
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        findViewById<Toolbar>(R.id.toolbar).setNavigationOnClickListener { finish() }

        val failures = intent.getSerializableExtra(EXTRA_ERRORS) as List<ErrorItem>
        findViewById<RecyclerView>(R.id.errors).apply {
            adapter = ErrorAdapter(failures)
            layoutManager = LinearLayoutManager(context)
        }
    }
}
