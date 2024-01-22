package com.angelhr28.novachallengeapp.ui.feature

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.angelhr28.novachallengeapp.R
import com.angelhr28.novachallengeapp.ui.entity.ShapeOption


@Composable
fun ShapesScreenContent() {
    var selectedOption by remember { mutableStateOf<ShapeOption?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Imagen que cambia según la opción seleccionada
        Image(
            painter = painterResource(
                id = selectedOption?.imageResId ?: R.drawable.ic_launcher_foreground
            ),
            contentDescription = "Selected Image",
            modifier = Modifier
                .size(120.dp)
                .clip(shape = MaterialTheme.shapes.medium)
                .background(MaterialTheme.colorScheme.primary)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Lista de RadioButton
        LazyColumn {
            items(ShapeOption.entries) { option ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .selectable(
                            selected = (option == selectedOption),
                            onClick = {
                                selectedOption = option
                            }
                        )
                        .padding(16.dp)
                ) {
                    RadioButton(
                        selected = (option == selectedOption),
                        onClick = {
                            selectedOption = option
                        }
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(text = option.radioOption, style = MaterialTheme.typography.bodyLarge)
                }
            }
        }
    }
}
