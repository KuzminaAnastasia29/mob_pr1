package ua.kpi.practical_work.pr1.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun AuthScreen(onAuthSuccess: () -> Unit) {
    var isLoginMode by remember { mutableStateOf(true) }
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = if (isLoginMode) "Вхід до Smart Grid" else "Реєстрація інженера",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = login,
            onValueChange = { login = it },
            label = { Text("Логін") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Пароль") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                if (login.isBlank() || password.isBlank()) {
                    errorMessage = "Будь ласка, заповніть усі поля"
                } else {
                    errorMessage = ""
                    onAuthSuccess() // Перехід на головний екран
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(if (isLoginMode) "Увійти" else "Зареєструватися")
        }

        if (errorMessage.isNotEmpty()) {
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = errorMessage, color = Color.Red)
        }

        Spacer(modifier = Modifier.height(12.dp))

        TextButton(onClick = {
            isLoginMode = !isLoginMode
            errorMessage = ""
        }) {
            Text(if (isLoginMode) "Створити акаунт" else "Вже є акаунт? Увійти")
        }
    }
}