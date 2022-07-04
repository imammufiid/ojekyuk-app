package com.mufiid.ojekyuk.ui

import android.os.Bundle
import com.mufiid.ojekyuk.R
import com.mufiid.ojekyuk.data.User
import com.mufiid.ojekyuk.databinding.ActivityMainBinding
import com.mufiid.ojekyuk.event.StateEventSubscriber
import org.koin.androidx.scope.ScopeActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ScopeActivity() {
    private val viewModel: MainViewModel by viewModel()

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.run {
            binding.btnFetch.setOnClickListener {
                viewModel.getUsers(1)
            }
        }

        viewModel.subscribeUser(subscribeUser)
    }

    private val subscribeUser = object : StateEventSubscriber<List<User>> {
        override fun onIdle() {
            binding.tvUser.append("Idle...\n")
        }

        override fun onLoading() {
            binding.tvUser.append("Loading...\n")
        }

        override fun onFailure(throwable: Throwable) {
            binding.tvUser.append("${throwable.message}...\n")
        }

        override fun onSuccess(data: List<User>) {
            binding.tvUser.append("$data...\n")
        }

    }
}