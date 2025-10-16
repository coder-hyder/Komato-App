package com.example.komatoapp.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.komatoapp.R
import com.example.komatoapp.presentation.components.HomeScreenCard
import com.example.komatoapp.presentation.components.TopAppBarDiningScreen
import com.example.komatoapp.presentation.utils.BottomSheetToAddProduct

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuickScreen(navController: NavController,listState: LazyListState) {

    val scrollBehaviour = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    val showBottomSheet = remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBarDiningScreen(scrollBehaviour,navController)
        }
    ) { innerPadding ->

        LazyColumn(contentPadding = PaddingValues(vertical = 0.dp) ,
            state = listState,
            modifier = Modifier
                .fillMaxSize().background(color = Color.White)
                .padding(bottom = innerPadding.calculateBottomPadding())
                .nestedScroll(scrollBehaviour.nestedScrollConnection)){
            item {
                Box(modifier = Modifier.fillMaxWidth()){
                    Image(
                        painter = painterResource(R.drawable.quickbanner),
                        modifier = Modifier.fillMaxSize()
                            .clip(shape = RoundedCornerShape(bottomStart = 15.dp, bottomEnd = 15.dp)),
                        contentDescription = "Quick Screen"
                    )
                }
            }

            item {
                LazyRow(modifier = Modifier.fillMaxWidth()) {

                    items(6){
                        QuickScrrenComponents(navController,onAddClick = {showBottomSheet.value = true})
                    }
                }
                if (showBottomSheet.value){
                    BottomSheetToAddProduct(
                        onDismiss = {showBottomSheet.value = false},
                        navController = navController
                    )
                }
            }

            item (5){
                Spacer(modifier =Modifier.height(16.dp))
                HomeScreenCard(navController)
                Spacer(modifier = )
            }
        }

    }
}