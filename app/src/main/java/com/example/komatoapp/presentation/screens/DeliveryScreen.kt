package com.example.komatoapp.presentation.screens

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.with
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.komatoapp.presentation.components.DeliveryScreenSearchBar
import com.example.komatoapp.presentation.components.FoodCategoryTabs
import com.example.komatoapp.presentation.components.TopAppBarDeliveryScreen
import com.example.komatoapp.presentation.screens.category_screen.AllCategoryScreen
import com.example.komatoapp.presentation.screens.category_screen.ChineseCategoryScreen
import com.example.komatoapp.presentation.screens.category_screen.PizzaCategoryScreen

@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
fun DeliveryScreen(navController: NavController, listState: LazyListState)
{

    var selectedTabIndex by rememberSaveable { mutableIntStateOf(0) }
    val scrollBehaviour = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    Scaffold(
        topBar = {
            Column(modifier = Modifier.fillMaxWidth().windowInsetsPadding(WindowInsets.statusBars)) {
                TopAppBarDeliveryScreen(scrollBehavior = scrollBehaviour,navController)
                Spacer(Modifier.height(3.dp))
                DeliveryScreenSearchBar(navController)

            }
        }
    ) {innerPadding ->
        LazyColumn(
            state = listState,
            contentPadding = PaddingValues(vertical = 0.dp),
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
                .padding(innerPadding)
                .nestedScroll(scrollBehaviour.nestedScrollConnection)
        ) {
            stickyHeader {
                FoodCategoryTabs(
                    modifier = Modifier.fillMaxWidth().background(color = Color.White),
                    selectedTabIndex = selectedTabIndex,
                    onTabSelected = {selectedTabIndex = it}
                )

            }
            item {
                AnimatedContent(
                    targetState = selectedTabIndex,
                    transitionSpec = {
                        if(targetState > initialState){
                            // forward direction(right)
                            slideInHorizontally { fullWidth -> fullWidth } + fadeIn() with
                                    slideOutHorizontally { width ->  - width } + fadeOut()
                        }else{
                            // reverse direction ( left)
                            slideInHorizontally { fullWidth -> fullWidth }+ fadeIn() with
                                    slideOutHorizontally { fullWidth -> fullWidth }+ fadeOut()
                        }
                    },
                    label = "SlideTabTransition"){index->
                    when(index){
                        0 -> AllCategoryScreen(navController)
                        1 -> PizzaCategoryScreen(navController)
                        2 -> ChineseCategoryScreen(navController)
                        else -> AllCategoryScreen(navController)
                    }
                }

            }
        }
    }
}