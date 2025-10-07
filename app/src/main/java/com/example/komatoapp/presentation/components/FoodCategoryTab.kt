package com.example.komatoapp.presentation.components

import android.R.attr.contentDescription
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage


import com.example.komatoapp.R
import com.example.komatoapp.domain.models.FoodCategory

@Composable
fun FoodCategoryTabs(
    modifier: Modifier = Modifier,
    selectedTabIndex:Int,
    onTabSelected:(Int) -> Unit)
{
    val categories = listOf(
        FoodCategory("All", R.drawable.allfood),
        FoodCategory("Pizza", R.drawable.pizza_image),
        FoodCategory("chinese", R.drawable.chinese),
        FoodCategory("burger", R.drawable.burger),
        FoodCategory("Biryani", R.drawable.vegbiryani),
        FoodCategory("Sweets", R.drawable.sweets),
        FoodCategory("Pasta", R.drawable.pasta),
        FoodCategory("Rolls", R.drawable.rolls),
        FoodCategory("Ice Cream", R.drawable.ice_cream),
    )

    ScrollableTabRow(
        selectedTabIndex = selectedTabIndex,
        containerColor = Color.White,
        contentColor = Color.Black,
        edgePadding = 8.dp,
        indicator = {tabPosition ->
            TabRowDefaults.Indicator(
                Modifier
                    .tabIndicatorOffset(tabPosition[selectedTabIndex])
                    .height(3.dp),
                    color = Color.Red
            )
        },
        divider = {
            HorizontalDivider(color = Color.LightGray, thickness = 0.6.dp)
        }

    ) {
        categories.forEachIndexed{index, category ->
            Tab(
                selected = selectedTabIndex == index,
                onClick = { onTabSelected(index)}
            ){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(8.dp)
                ) {
                    AsyncImage(
                        model = category.image,
                        modifier = Modifier.size(60.dp),
                        contentDescription = category.name,

                    )

                    Text(
                        text = category.name,
                        fontSize = 12.sp,
                        fontWeight = if(selectedTabIndex == index) FontWeight.Bold else FontWeight.Normal,
                        color = if(selectedTabIndex == index) Color.Black else  Color.DarkGray
                    )
                }
            }
        }
    }
}
