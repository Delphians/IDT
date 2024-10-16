package com.che.idt.ui.screens

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.che.idt.domain.fakes.fakeUsaStatesList
import com.che.idt.domain.model.UsaState
import com.che.idt.ui.theme.IDTTheme
import kotlinx.collections.immutable.PersistentList

@Composable
internal fun StatesListScreen(
    modifier: Modifier = Modifier,
    states: PersistentList<UsaState>,
    onClick: (UsaState) -> Unit,
    onDoubleClick: (UsaState) -> Unit
) {
    LazyColumn(modifier = modifier) {
        items(
            items = states,
            key = { item: UsaState ->
                item.state
            }
        ) { state ->
            Card(
                modifier = Modifier
                    .fillParentMaxWidth()
                    .padding(10.dp)
                    .pointerInput(Unit) {
                        detectTapGestures(
                            onTap = {
                                onClick(state)
                            },
                            onDoubleTap = {
                                onDoubleClick(state)
                            }
                        )
                    },
                colors = CardDefaults.cardColors(
                    containerColor = if (state.isHighlighted) {
                        Color.Red
                    } else {
                        MaterialTheme.colorScheme.surfaceVariant
                    },
                )
            ) {
                Text(
                    text = state.state,
                    modifier = Modifier.padding(start = 10.dp),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun StatesListScreenPreview() {
    IDTTheme {
        StatesListScreen(
            states = fakeUsaStatesList, onClick = {}, onDoubleClick = {}
        )
    }
}
