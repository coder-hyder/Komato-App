package com.example.komatoapp.presentation.screens.category_screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun PizzaCategoryScreen(navController: NavController) {
    ChineseCategoryCards(navController)
}