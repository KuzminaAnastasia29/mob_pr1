package ua.kpi.practical_work.pr1.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ua.kpi.practical_work.pr1.data.SmartGridCalculator

@Composable
fun SmartGridApp() {
    var consumerLoad by remember { mutableStateOf("") }
    var gridEfficiency by remember { mutableStateOf("") }
    var reserveCapacity by remember { mutableStateOf("") }
    var result by remember { mutableStateOf(0.0) }

    val calculator = SmartGridCalculator()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Smart Grid: Розподіл енергії", style = MaterialTheme.typography.titleLarge)

        OutlinedTextField(
            value = consumerLoad,
            onValueChange = { consumerLoad = it },
            label = { Text("Навантаження споживачів (кВт)") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = gridEfficiency,
            onValueChange = { gridEfficiency = it },
            label = { Text("Ефективність ліній (%)") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = reserveCapacity,
            onValueChange = { reserveCapacity = it },
            label = { Text("Резервна потужність (%)") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                result = calculator.calculateRequiredPower(consumerLoad, gridEfficiency, reserveCapacity)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Розрахувати необхідну потужність")
        }

        if (result > 0) {
            Text(
                text = "Необхідна потужність мережі: ${"%.2f".format(result)} кВт",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}