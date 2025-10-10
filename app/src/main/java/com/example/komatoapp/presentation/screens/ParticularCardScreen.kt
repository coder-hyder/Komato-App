package com.example.komatoapp.presentation.screens

import android.R.attr.contentDescription
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.komatoapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ParticularScreen(modifier: Modifier = Modifier, navController: NavController) {

    var showBottomSheet = remember { mutableStateOf(false) }

    var firstName by remember { mutableStateOf("Rominus Pizza") }
    var lastName by remember { mutableStateOf("Burger") }
    var rating by remember { mutableStateOf("4.2") }
    var time by remember { mutableStateOf("37 mins") }
    var distance by remember { mutableStateOf("2.6 km") }
    var address by remember { mutableStateOf("Crossing Republic") }
    var uniqueness by remember { mutableStateOf("On time Preparation") }
    var discount by remember { mutableStateOf("Flat Rs50 OFF on above Rs249") }
    var offers by remember { mutableStateOf("2 offers") }
    var price by remember { mutableStateOf("Rs249") }
    var productName by remember { mutableStateOf("Peri Peri Burger") }

    val scrollBehaviour = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    Scaffold(
        containerColor = Color.Gray,
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(Color.White),
                title = {},
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(
                            painter = painterResource(R.drawable.arrowback),
                            tint = Color.Black,
                            modifier = Modifier.size(28.dp),
                            contentDescription = "Back Navigation"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(R.drawable.outline_group_add_24),
                            tint = Color.Black,
                            modifier = Modifier.size(28.dp),
                            contentDescription = "Group Add"
                        )
                    }
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(R.drawable.outline_bookmark_24),
                            tint = Color.Black,
                            modifier = Modifier.size(28.dp),
                            contentDescription = "Save or favourite"
                        )
                    }

                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(R.drawable.outline_more_vert_24),
                            tint = Color.Black,
                            modifier = Modifier.size(28.dp),
                            contentDescription = "More menu"
                        )
                    }
                },
                scrollBehavior = scrollBehaviour
            )
        }
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .nestedScroll(scrollBehaviour.nestedScrollConnection)
                .padding(innerPadding)
        ) {

            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.White)
                        .height(190.dp)
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp, vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(
                                text = firstName,
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                fontSize = 25.sp
                            )
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = lastName,
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 25.sp
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Icon(
                                    painter = painterResource(R.drawable.outline_info_24),
                                    tint = Color.Gray,
                                    contentDescription = "Information"
                                )
                            }
                        }
                        Column {
                            Card(
                                modifier = Modifier.size(width = 55.dp, height = 30.dp),
                                shape = RoundedCornerShape(6.dp),
                                colors = CardDefaults.cardColors(Color.Green)
                            ) {

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceEvenly
                                ) {
                                    Text(
                                        text = rating,
                                        modifier = Modifier.padding(start = 4.dp, top = 4.dp),
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        color = Color.White
                                    )
                                    Icon(
                                        painterResource(R.drawable.star),
                                        modifier = Modifier
                                            .padding(
                                                start = 5.dp,
                                                top = 2.dp,
                                                end = 4.dp
                                            )
                                            .size(18.dp),
                                        tint = Color.White,
                                        contentDescription = null
                                    )
                                }
                            }
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.timer),
                            modifier = Modifier.size(17.dp),
                            tint = Color.DarkGray,
                            contentDescription = "time clock"
                        )

                        Text(
                            text = time, fontSize = 14.sp,
                            color = Color.DarkGray,
                            modifier = Modifier.padding(start = 4.dp)
                        )

                        Icon(
                            painter = painterResource(R.drawable.dot),
                            tint = Color.DarkGray,
                            modifier = Modifier.size(16.dp),
                            contentDescription = "Dot"
                        )
                        Text(text = distance, fontSize = 14.sp, color = Color.DarkGray)

                        Icon(
                            painter = painterResource(R.drawable.dot),
                            modifier = Modifier.size(17.dp),
                            contentDescription = "dot"
                        )
                        Text(text = address, fontSize = 14.sp, color = Color.DarkGray)

                        Icon(
                            painter = painterResource(R.drawable.arrowdown),
                            modifier = Modifier
                                .padding(start = 2.dp)
                                .size(17.dp),
                            contentDescription = "arrow down"
                        )

                    }
                    Card(
                        modifier = Modifier
                            .padding(start = 8.dp, 8.dp)
                            .width(165.dp)
                            .height(22.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(Color.Gray.copy(alpha = 0.1f))
                    )
                    {
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Icon(
                                painterResource(R.drawable.check),
                                modifier = Modifier
                                    .padding(start = 8.dp, top = 6.dp)
                                    .size(12.dp),
                                tint = Color.Green,
                                contentDescription = null
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(text = uniqueness, color = Color.Gray, fontSize = 14.sp)
                        }
                    }
                    HorizontalDivider(
                        modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 16.dp),
                        color = Color.Gray,
                        thickness = 1.dp
                    )
                }
            }
        }
    }
}