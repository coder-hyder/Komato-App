package com.example.komatoapp.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.komatoapp.R
import com.example.komatoapp.domain.models.FoodCategory
import com.example.komatoapp.domain.models.TabItems
import com.example.komatoapp.presentation.utils.SearchBarDiningTabScreen
import com.google.android.play.integrity.internal.f

@Composable
fun SearchBarScreen(modifier: Modifier = Modifier,navController: NavController) {

    Column(modifier = Modifier
        .fillMaxWidth()
        .systemBarsPadding()) {
        var searchQuery by remember{ mutableStateOf("") }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White)
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically){

            Surface(
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp),
                shape = RoundedCornerShape(16.dp),
                color = Color.White,
                shadowElevation = 2.dp
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(R.drawable.arrowback),
                        contentDescription = "Search",
                        tint = colorResource(R.color.purple_200),
                        modifier = Modifier
                            .size(20.dp)
                            .clickable {
                                navController.popBackStack()
                            }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    // search text field
                    BasicTextField(
                        value = searchQuery,
                        onValueChange = {
                            searchQuery = it
                        },
                        modifier = Modifier.weight(1f),
                        textStyle = TextStyle(
                            fontSize = 16.sp,
                            color = Color.Gray
                        ),
                        decorationBox = {innerPadding ->
                            Box{
                                if (searchQuery.isEmpty()){
                                    Text(
                                        text = "Search \"Restaurant\"",
                                        color = Color.Gray,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 15.sp
                                    )
                                }
                                innerPadding

                            }
                        },
                        singleLine = true
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    VerticalDivider(modifier = Modifier.padding(vertical = 10.dp),
                        thickness = 0.5.dp, color = Color.LightGray)
                    Spacer(modifier = Modifier.width(10.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.mic),
                        contentDescription = "Voice Search",
                        tint = colorResource(R.color.purple_700),
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }
        TabItem()
    }
}

@Composable
fun TabItem(modifier: Modifier = Modifier) {

    val tabItems = listOf<TabItems>(
        TabItems("Delivery"),
        TabItems("Dining")
    )

    var selectedIndex by remember{mutableIntStateOf(0)}

    Column (modifier = Modifier.fillMaxWidth()){
        TabRow(
            selectedTabIndex = selectedIndex,
            containerColor = Color.White,
            indicator = {tabPosition ->
                TabRowDefaults.Indicator(
                    modifier = Modifier.tabIndicatorOffset(tabPosition[selectedIndex]),
                    color = colorResource(R.color.purple_500)
                )
            }
        ) {
            tabItems.forEachIndexed { index, items ->
                Tab(
                    selected = index == selectedIndex,
                    selectedContentColor =  colorResource(R.color.purple_500),
                    unselectedContentColor = Color.Gray,
                    onClick = {
                        selectedIndex = index
                    },
                    text = {
                        Text(text = items.title,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 18.sp)
                    }
                )
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        // Directly show  the  screen  based on selected index
        when(selectedIndex){
            0 -> FoodCategoryList()
            1 -> SearchBarDiningTabScreen()
        }
    }
}