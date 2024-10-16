package com.che.idt.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.che.idt.MainScreenState
import com.che.idt.R
import com.che.idt.domain.fakes.fakeUsaStatesList
import com.che.idt.domain.model.UsaState
import com.che.idt.ui.theme.IDTTheme

@Composable
internal fun UsaStateScreen(
    modifier: Modifier = Modifier,
    state: State<MainScreenState>,
    onTextChange: (String) -> Unit,
    onStateClick: (UsaState) -> Unit,
    onHighlightedStateClick: (UsaState) -> Unit
) {
    val text = remember { mutableStateOf("") }
    val usaState = state.value

    Column(modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .background(Color.Cyan)
        ) {
            TextField(
                value = text.value,
                onValueChange = {
                    text.value = it
                    onTextChange(it)
                },
                placeholder = { Text(stringResource(R.string.searchState)) }
            )
            ElevatedButton(onClick = {}, modifier = Modifier.padding(start = 10.dp, top = 5.dp)) {
                Text(stringResource(R.string.openInSecondScreen))
            }
        }
        Row {
            StatesListScreen(
                modifier = Modifier
                    .background(Color.Yellow)
                    .weight(1f),
                states = usaState.usaSatesFullList,
                onClick = { onStateClick(it) },
                onDoubleClick = {
                    onHighlightedStateClick(it)
                }
            )
            StatesListScreen(
                modifier = Modifier
                    .background(Color.Green)
                    .weight(1f),
                states = usaState.usaStateFilteredList,
                onClick = { onStateClick(it) },
                onDoubleClick = {
                    onHighlightedStateClick(it)
                }
            )
            Box(
                modifier = Modifier
                    .background(Color.Red)
                    .weight(2f)
                    .fillMaxHeight()
            ) {
                usaState.usaState?.let {
                    Text(
                        text = buildAnnotatedString {
                            append("${stringResource(R.string.stateName)} \n")
                            append("${usaState.usaState.state} \n")
                            append("${stringResource(R.string.stateOverallPopulation)} \n")
                            append("${usaState.usaState.population} \n")
                            append("${stringResource(R.string.numberOfCounties)} \n")
                            append("${usaState.usaState.counties} \n")
                        },
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun UsaStateScreenPreview() {
    val state = remember {
        mutableStateOf(
            MainScreenState(
                usaSatesFullList = fakeUsaStatesList,
                usaStateFilteredList = fakeUsaStatesList
            )
        )
    }
    IDTTheme {
        UsaStateScreen(
            state = state,
            onTextChange = {},
            onStateClick = {},
            onHighlightedStateClick = {}
        )
    }
}
