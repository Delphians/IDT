package com.che.idt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.che.idt.ui.screens.FailureDialog
import com.che.idt.ui.screens.LoadingIndicator
import com.che.idt.ui.screens.UsaStateScreen
import com.che.idt.ui.theme.IDTTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
internal class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        viewModel.fetchUsaStates()

        setContent {
            val state = viewModel.mainScreenState.collectAsState()
            IDTTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(
                        state = state,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    @Composable
    private fun MainScreen(
        state: State<MainScreenState>,
        modifier: Modifier = Modifier
    ) {
        state.value.let {
            when {
                it.isLoading -> LoadingIndicator()
                it.errorMessage -> FailureDialog(
                    title = stringResource(id = R.string.error),
                    text = "",
                    onDismiss = { viewModel.onUsersStateErrorClose() }
                )
                else -> UsaStateScreen(
                    modifier, state,
                    onTextChange = {
                        viewModel.filterUsaStates(it)
                    },
                    onStateClick = {
                        viewModel.onUsaStateClick(it)
                    },
                    onHighlightedStateClick = {
                        viewModel.onHighlightStateClick(it)
                    }
                )
            }
        }
    }
}
