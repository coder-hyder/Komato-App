package com.example.komatoapp.presentation.screens

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.komatoapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavHostController) {

    Scaffold(
        modifier = Modifier.fillMaxWidth(),
        topBar = {
            TopAppBar(
                modifier = Modifier.background(color = Color.White),
                title = {},
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "ArrowBack"
                        )
                    }
                })

        }) { values ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Gray)
                .padding(values)
        ) {

            Spacer(modifier = Modifier.height(8.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp)
                    .padding(horizontal = 10.dp),
                shape = RoundedCornerShape(
                    topStart = 12.dp,
                    topEnd = 12.dp,
                    bottomStart = 0.dp,
                    bottomEnd = 0.dp
                ),
                colors = CardDefaults.cardColors(Color.White)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Icon(
                        modifier = Modifier
                            .size(80.dp)
                            .clip(CircleShape),
                        painter = painterResource(id = R.drawable.profielogo),
                        contentDescription = "Profile Image",
                        tint = Color.Unspecified
                    )
                    Spacer(modifier = Modifier.width(7.dp))
                    Column {
                        Text(
                            text = "Name",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 23.sp
                        )
                        Text(
                            text = "gmail2025gmail.com",
                            color = Color.DarkGray,
                            fontSize = 12.sp
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(2.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "View activity",
                                fontSize = 13.sp,
                                color = colorResource(id = R.color.purple_500)
                            )

                            Icon(
                                imageVector = Icons.Default.PlayArrow,
                                tint = Color.DarkGray,
                                contentDescription = "Forward Arrow",
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    }
                }

            }
            // Here will be the lazy column
            ZomatoGold()
            // column_grid()
            Lazycolumn()
        }
    }
}



@Composable
fun ZomatoGold() {

    Card(
        colors = CardDefaults.cardColors(containerColor = Color.Black),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
            .height(65.dp),
        shape = RoundedCornerShape(
            bottomEnd = 12.dp,
            bottomStart = 12.dp,
            topEnd = 0.dp,
            topStart = 0.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                painterResource(R.drawable.goldicon1),
                contentDescription = "Zomato gold Image",
                tint = Color.Unspecified
            )

            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "Join Zomato Gold",
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.purple_500)
            )

            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "Arrow Right",
                tint = Color.White
            )
        }
    }
}

@Composable
fun ColumnGrid(card: CardItem.ColoumnGrid) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Icon(
                    painterResource(R.drawable.outline_bookmark_24),
                    contentDescription = "Collection",
                    tint = Color.Gray,
                    modifier = Modifier
                        .padding(start = 20.dp, top = 15.dp, bottom = 5.dp)
                        .size(30.dp)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 10.dp)
                ) {
                    Text(
                        text = "Collection",
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
        Spacer(modifier = Modifier.width(10.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Icon(
                    painterResource(R.drawable.rupeesymbol),
                    contentDescription = "Money",
                    tint = Color.Gray,
                    modifier = Modifier
                        .padding(
                            start = 20.dp, top = 15.dp, bottom = 5.dp
                        )
                        .size(30.dp)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 10.dp)
                ) {
                    Text(
                        text = "Money",
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                    Spacer(modifier = Modifier.width(10.dp))
                    Row(
                        modifier = Modifier
                            .size(width = 30.dp, height = 20.dp)
                            .background(color = colorResource(R.color.purple_500)),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Rs0",
                            color = colorResource(R.color.purple_500),
                            fontSize = 14.sp
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Lazycolumn() {
    val cardList = listOf(
        CardItem.ColoumnGrid(name = "Ayush"),
        CardItem.FirstCard(Profilename = "Your Profile", percentagetext = "48%Completed"),
        CardItem.SecondCard(vegtext = "Veg Mode"),
        CardItem.ThirdCard(Appearance = "Appearance"),
        CardItem.FourthCard(rating = "Your rating"),
        CardItem.FifthCard(Food_Order = "Food Orders"),
        CardItem.SixthCard(Titilename = "Dining and Experience"),
        CardItem.SeventhCard(title = "done"),
        CardItem.EighthCard(Title = "done"),
        CardItem.NinthCard(Title = "done"),
        CardItem.TenCard(Title = "done"),
        CardItem.EleventhCard(Title = "eleventhdone")
    )

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(cardList) { item ->

            when (item) {
                is CardItem.ColoumnGrid -> ColumnGrid(item)
                is CardItem.FirstCard -> ProductCard(item)
                is CardItem.SecondCard ->  VegModeCard(item)
                is CardItem.ThirdCard -> AppearanceCard(item)
                is CardItem.FourthCard -> RatingCard(item)
                is CardItem.FifthCard -> FoodOrderCard(item)
                is CardItem.SixthCard -> DiningFood(item)
                is CardItem.SeventhCard -> SeventhCard(item)
                is CardItem.EighthCard -> EightCard(item)
                is CardItem.NinthCard -> NinthCard(item)
                is CardItem.TenCard -> TenthCard(item)
                is CardItem.EleventhCard -> (item)

            }
        }
    }
}

@Composable
fun ProductCard(card: CardItem.FirstCard) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = "Your Profile Icon",
                modifier = Modifier.size(25.dp),
                tint = Color.LightGray
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = "Your Profile", color = Color.Black)
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "48% Completed",
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(12.dp))
                    .background(color = colorResource(R.color.purple_500)),
                color = colorResource(R.color.purple_500),
                fontWeight = FontWeight.SemiBold,
                fontSize = 15.sp
            )

            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "Forward arrow",
                modifier = Modifier.padding(start = 5.dp),
                tint = Color.DarkGray
            )
        }
    }
}

@Composable
fun VegModeCard(card: CardItem.SecondCard) {
    var switch1 by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    )
    {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painterResource(R.drawable.veg_icon),
                contentDescription = "Veg Mode Icon",
                modifier = Modifier.size(22.dp),
                tint = colorResource(R.color.purple_500)
            )

            Spacer(modifier = Modifier.width(6.dp))
            Text(text = "Veg Mode", color = Color.Black)
            Spacer(modifier = Modifier.weight(1f))
            //Toggle Button for the veg mode
            Switch(
                checked = switch1,
                onCheckedChange = { switch1 = it },
                colors = SwitchDefaults.colors(checkedIconColor = Color.Green),
                modifier = Modifier.height(16.dp)
            )
        }
    }
}

@Composable
fun AppearanceCard(card: CardItem.ThirdCard) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    )
    {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Appearance one icon need to bee added download
            Icon(
                painterResource(R.drawable.paint),
                contentDescription = "Your Profile",
                modifier = Modifier.size(20.dp),
                tint = Color.LightGray
            )
            Text(text = "Appearance", color = Color.Black)
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "LIGHT",
                fontWeight = FontWeight.Bold,
                color = Color.Gray
            )
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "Forward arrow",
                tint = Color.Gray
            )
        }
    }
}

@Composable
fun RatingCard(card: CardItem.FourthCard) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    )
    {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // rating icon need to be added download
            Icon(
                painter = painterResource(R.drawable.rating),
                contentDescription = "Rating icon",
                modifier = Modifier.size(25.dp),
                tint = Color.LightGray
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = "Your rating", color = Color.Black)
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                painterResource(R.drawable.startrating),
                contentDescription = "Star rating",
                tint = Color.Unspecified
            )

        }


    }
}

@Composable
fun FoodOrderCard(card: CardItem.FifthCard) {

    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 10.dp)
            .fillMaxWidth()
            .height(400.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {

        Column {
            Row {
                VerticalDivider(
                    thickness = 3.dp,
                    modifier = Modifier
                        .height(34.dp)
                        .padding(top = 12.dp)
                        .clip(shape = RoundedCornerShape(10.dp)),
                    color = colorResource(R.color.purple_500)
                )

                Text(
                    text = "Food orders",
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 10.dp, top = 10.dp)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                // Rating icon need to bee added download
                Icon(
                    painterResource(R.drawable.order),
                    contentDescription = "Your orders",
                    modifier = Modifier.size(25.dp),
                    tint = Color.LightGray
                )

                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Your orders", color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "Forward arrow",
                    tint = Color.Gray
                )
            }
            HorizontalDivider(
                thickness = 0.5.dp,
                modifier = Modifier
                    .padding(start = 53.dp, top = 10.dp)
                    .weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Rating icon need to bee added donwload
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "Your Profile",
                    modifier = Modifier.size(25.dp),
                    tint = Color.LightGray
                )

                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Favorite orders", color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "Forward arrow",
                    tint = Color.Gray
                )
            }
            HorizontalDivider(
                thickness = 0.5.dp,
                modifier = Modifier
                    .padding(start = 53.dp, top = 10.dp)
                    .weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                // Rating icon need to bee added download
                Icon(
                    painterResource(R.drawable.thumbs),
                    contentDescription = "Your Profile",
                    modifier = Modifier.size(25.dp),
                    tint = Color.LightGray
                )

                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Manage recommendations", color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "Forward arrow",
                    tint = Color.Gray
                )

            }
            HorizontalDivider(
                thickness = 0.5.dp,
                modifier = Modifier
                    .padding(start = 53.dp, top = 10.dp)
                    .weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                // Rating icon need to bee added download
                Icon(
                    painterResource(R.drawable.train),
                    contentDescription = "Your Profile",
                    modifier = Modifier.size(25.dp),
                    tint = Color.LightGray
                )

                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Order on train", color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "Forward arrow",
                    tint = Color.Gray
                )

            }
            HorizontalDivider(
                thickness = 0.5.dp,
                modifier = Modifier
                    .padding(start = 53.dp, top = 10.dp)
                    .weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                // Rating icon need to bee added download
                Icon(
                    painterResource(R.drawable.addressbook),
                    contentDescription = "Your Profile",
                    modifier = Modifier.size(25.dp),
                    tint = Color.LightGray
                )

                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Address book", color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "Forward arrow",
                    tint = Color.Gray
                )
            }

            HorizontalDivider(
                thickness = 0.5.dp,
                modifier = Modifier
                    .padding(start = 53.dp, top = 10.dp)
                    .weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                // Rating icon need to bee added download
                Icon(
                    painterResource(R.drawable.hiddden),
                    contentDescription = "Your Profile",
                    modifier = Modifier.size(25.dp),
                    tint = Color.LightGray
                )

                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Hidden Restaurants", color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "Forward arrow",
                    tint = Color.Gray
                )
            }

            HorizontalDivider(
                thickness = 0.5.dp,
                modifier = Modifier
                    .padding(start = 53.dp, top = 10.dp)
                    .weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                // Rating icon need to bee added download
                Icon(
                    painterResource(R.drawable.message),
                    contentDescription = "Your Profile",
                    modifier = Modifier.size(25.dp),
                    tint = Color.LightGray
                )

                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Online ordering help", color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "Forward arrow",
                    tint = Color.Gray
                )
            }
            Spacer(modifier = Modifier.width(4.dp))
        }
    }
}


@Composable
fun DiningFood(card: CardItem.SixthCard) {


    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 10.dp)
            .fillMaxWidth()
            .height(350.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {

        Column {
            Row {
                VerticalDivider(
                    thickness = 3.dp,
                    modifier = Modifier
                        .height(34.dp)
                        .padding(top = 12.dp)
                        .clip(shape = RoundedCornerShape(10.dp)),
                    color = colorResource(R.color.purple_500)
                )

                Text(
                    text = "Dining and Experiences",
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 10.dp, top = 10.dp)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                // Rating icon need to bee added download
                Icon(
                    painterResource(R.drawable.hiddden),
                    contentDescription = "Your orders",
                    modifier = Modifier.size(25.dp),
                    tint = Color.LightGray
                )

                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Your dining transactions", color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "Forward arrow",
                    tint = Color.Gray
                )
            }
            HorizontalDivider(
                thickness = 0.5.dp,
                modifier = Modifier
                    .padding(start = 53.dp, top = 10.dp)
                    .weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Rating icon need to bee added donwload
                Icon(
                    painterResource(R.drawable.gift),
                    contentDescription = "Your Profile",
                    modifier = Modifier.size(25.dp),
                    tint = Color.LightGray
                )

                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Your dining rewards", color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "Forward arrow",
                    tint = Color.Gray
                )
            }
            HorizontalDivider(
                thickness = 0.5.dp,
                modifier = Modifier
                    .padding(start = 53.dp, top = 10.dp)
                    .weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                // Rating icon need to bee added download
                Icon(
                    painterResource(R.drawable.dining),
                    contentDescription = "Your Profile",
                    modifier = Modifier.size(25.dp),
                    tint = Color.LightGray
                )

                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Your bookings", color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "Forward arrow",
                    tint = Color.Gray
                )

            }
            HorizontalDivider(
                thickness = 0.5.dp,
                modifier = Modifier
                    .padding(start = 53.dp, top = 10.dp)
                    .weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                // Rating icon need to bee added download
                Icon(
                    painterResource(R.drawable.message),
                    contentDescription = "Your Profile",
                    modifier = Modifier.size(25.dp),
                    tint = Color.LightGray
                )

                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Dining help", color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "Forward arrow",
                    tint = Color.Gray
                )

            }
            HorizontalDivider(
                thickness = 0.5.dp,
                modifier = Modifier
                    .padding(start = 53.dp, top = 10.dp)
                    .weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                // Rating icon need to bee added download
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Your Profile",
                    modifier = Modifier.size(25.dp),
                    tint = Color.LightGray
                )

                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Dining settings", color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "Forward arrow",
                    tint = Color.Gray
                )
            }

            HorizontalDivider(
                thickness = 0.5.dp,
                modifier = Modifier
                    .padding(start = 53.dp, top = 10.dp)
                    .weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                // Rating icon need to bee added download
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "Your Profile",
                    modifier = Modifier.size(25.dp),
                    tint = Color.LightGray
                )

                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Frequently asked questions", color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "Forward arrow",
                    tint = Color.Gray
                )
            }
            Spacer(modifier = Modifier.width(4.dp))
        }
    }
}


@Composable
fun SeventhCard(card: CardItem.SeventhCard) {

    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 10.dp)
            .fillMaxWidth()
            .height(120.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {

        Column {
            Row {
                VerticalDivider(
                    thickness = 3.dp,
                    modifier = Modifier
                        .height(34.dp)
                        .padding(top = 12.dp)
                        .clip(shape = RoundedCornerShape(10.dp)),
                    color = colorResource(R.color.purple_500)
                )

                Text(
                    text = "Feeding India",
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 10.dp, top = 10.dp)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                // Rating icon need to bee added download
                Icon(
                    painterResource(R.drawable.impact),
                    contentDescription = "Your orders",
                    modifier = Modifier.size(25.dp),
                    tint = Color.LightGray
                )

                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Your impact", color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "Forward arrow",
                    tint = Color.Gray
                )
            }
            HorizontalDivider(
                thickness = 0.5.dp,
                modifier = Modifier
                    .padding(start = 53.dp, top = 10.dp)
                    .weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Rating icon need to bee added donwload
                Icon(
                    painterResource(R.drawable.reciept),
                    contentDescription = "Your Profile",
                    modifier = Modifier
                        .size(25.dp)
                        .padding(start = 5.dp),
                    tint = Color.LightGray
                )

                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Get Feeding India receipt", color = Color.Black,
                    modifier = Modifier
                        .padding(start = 5.dp, top = 10.dp)
                        .weight(1f)
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "Forward arrow",
                    tint = Color.Gray,
                    modifier = Modifier.padding(start = 5.dp, top = 10.dp)
                )
            }
        }
    }
}

@Composable
fun EightCard(card: CardItem.EighthCard) {

    Card(
        modifier = Modifier
            .padding(
                start = 10.dp, top = 13.dp, end = 10.dp
            )
            .fillMaxWidth()
            .height(310.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {

        Column {
            Row {
                VerticalDivider(
                    thickness = 3.dp,
                    modifier = Modifier
                        .height(34.dp)
                        .padding(top = 12.dp)
                        .clip(shape = RoundedCornerShape(10.dp)),
                    color = colorResource(R.color.purple_500)
                )

                Text(
                    text = "Money",
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 10.dp, top = 10.dp)
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painterResource(R.drawable.rupeesymbol),
                    contentDescription = "Your ordrr",
                    modifier = Modifier.padding(start = 5.dp , top = 10.dp),
                    tint = Color.LightGray
                )
                Text(
                    text = "Zomato Money",
                    color = Color.Black,
                    modifier = Modifier
                        .padding(start = 5.dp, top = 10.dp)
                        .weight(1f)
                )

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward arrow",
                    modifier = Modifier.padding(start = 5.dp, top = 10.dp),
                    tint = Color.Gray
                )
            }

            HorizontalDivider(
                thickness = 0.5.dp,
                modifier = Modifier
                    .padding(start = 53.dp, top = 10.dp)
                    .weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painterResource(R.drawable.giftcard),
                    contentDescription = "Your ordrr",
                    modifier = Modifier.padding(start = 5.dp , top = 10.dp),
                    tint = Color.LightGray
                )
                Text(
                    text = "Buy Gift Card",
                    color = Color.Black,
                    modifier = Modifier
                        .padding(start = 5.dp, top = 10.dp)
                        .weight(1f)
                )

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward arrow",
                    modifier = Modifier.padding(start = 5.dp, top = 10.dp),
                    tint = Color.Gray
                )
            }
            HorizontalDivider(
                thickness = 0.5.dp,
                modifier = Modifier
                    .padding(start = 53.dp, top = 10.dp)
                    .weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )

        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painterResource(R.drawable.claimgiftcard),
                contentDescription = "Your ordrr",
                modifier = Modifier.padding(start = 5.dp , top = 10.dp),
                tint = Color.LightGray
            )
            Text(
                text = "Claim Gift Card",
                color = Color.Black,
                modifier = Modifier
                    .padding(start = 5.dp, top = 10.dp)
                    .weight(1f)
            )

            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "forward arrow",
                modifier = Modifier.padding(start = 5.dp, top = 10.dp),
                tint = Color.Gray
            )
        }
        HorizontalDivider(
            thickness = 0.5.dp,
            modifier = Modifier
                .padding(start = 53.dp, top = 10.dp)
                .weight(0.2f),
            color = Color.LightGray.copy(alpha = 0.4f)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painterResource(R.drawable.z),
                contentDescription = "Your ordrr",
                modifier = Modifier.padding(start = 5.dp , top = 10.dp),
                tint = Color.LightGray
            )
            Text(
                text = "Zomato Credits",
                color = Color.Black,
                modifier = Modifier
                    .padding(start = 5.dp, top = 10.dp)
                    .weight(1f)
            )

            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "forward arrow",
                modifier = Modifier.padding(start = 5.dp, top = 10.dp),
                tint = Color.Gray
            )
        }
        HorizontalDivider(
            thickness = 0.5.dp,
            modifier = Modifier
                .padding(start = 53.dp, top = 10.dp)
                .weight(0.2f),
            color = Color.LightGray.copy(alpha = 0.4f)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painterResource(R.drawable.payment),
                contentDescription = "Your ordrr",
                modifier = Modifier.padding(start = 5.dp , top = 10.dp),
                tint = Color.LightGray
            )
            Text(
                text = "Payment settings",
                color = Color.Black,
                modifier = Modifier
                    .padding(start = 5.dp, top = 10.dp)
                    .weight(1f)
            )

            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "forward arrow",
                modifier = Modifier.padding(start = 5.dp, top = 10.dp),
                tint = Color.Gray
            )
        }
    }
}


@Composable
fun NinthCard(card: CardItem.NinthCard) {

    Card(
        modifier = Modifier
            .padding(
                start = 10.dp, top = 13.dp, end = 10.dp
            )
            .fillMaxWidth()
            .height(120.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {

        Column {
            Row {
                VerticalDivider(
                    thickness = 3.dp,
                    modifier = Modifier
                        .height(34.dp)
                        .padding(top = 12.dp)
                        .clip(shape = RoundedCornerShape(10.dp)),
                    color = colorResource(R.color.purple_500)
                )

                Text(
                    text = "Zomato For Enterprise",
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 10.dp, top = 10.dp)
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painterResource(R.drawable.building),
                    contentDescription = "Your ordrr",
                    modifier = Modifier.padding(start = 5.dp , top = 10.dp),
                    tint = Color.LightGray
                )
                Text(
                    text = "For employs",
                    color = Color.Black,
                    modifier = Modifier
                        .padding(start = 5.dp, top = 10.dp)
                        .weight(1f)
                )

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward arrow",
                    modifier = Modifier.padding(start = 5.dp, top = 10.dp),
                    tint = Color.Gray
                )
            }

            HorizontalDivider(
                thickness = 0.5.dp,
                modifier = Modifier
                    .padding(start = 53.dp, top = 10.dp)
                    .weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painterResource(R.drawable.empcard),
                    contentDescription = "Your ordrr",
                    modifier = Modifier.padding(start = 5.dp),
                    tint = Color.LightGray
                )
                Text(
                    text = "For employs",
                    color = Color.Black,
                    modifier = Modifier
                        .padding(start = 5.dp, top = 10.dp)
                        .weight(1f)
                )

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward arrow",
                    modifier = Modifier.padding(start = 5.dp, top = 10.dp),
                    tint = Color.Gray
                )
            }
        }
    }
}


@Composable
fun TenthCard(card : CardItem.TenCard) {

    Card(
        modifier = Modifier
            .padding(
                start = 10.dp, top = 13.dp, end = 10.dp
            )
            .fillMaxWidth()
            .height(120.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {

        Column {
            Row {
                VerticalDivider(
                    thickness = 3.dp,
                    modifier = Modifier
                        .height(34.dp)
                        .padding(top = 12.dp)
                        .clip(shape = RoundedCornerShape(10.dp)),
                    color = colorResource(R.color.purple_500)
                )

                Text(
                    text = "Coupons",
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 10.dp, top = 10.dp)
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painterResource(R.drawable.coupons),
                    contentDescription = "Your ordrr",
                    modifier = Modifier.padding(start = 5.dp),
                    tint = Color.LightGray
                )
                Text(
                    text = "Collected coupons",
                    color = Color.Black,
                    modifier = Modifier
                        .padding(start = 5.dp, top = 10.dp)
                        .weight(1f)
                )

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward arrow",
                    modifier = Modifier.padding(start = 5.dp, top = 10.dp),
                    tint = Color.Gray
                )
            }

            HorizontalDivider(
                thickness = 0.5.dp,
                modifier = Modifier
                    .padding(start = 53.dp, top = 10.dp)
                    .weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painterResource(R.drawable.coupons),
                    contentDescription = "Your ordrr",
                    modifier = Modifier.padding(start = 5.dp),
                    tint = Color.LightGray
                )
                Text(
                    text = "Redeem Gold coupons",
                    color = Color.Black,
                    modifier = Modifier
                        .padding(start = 5.dp, top = 10.dp)
                        .weight(1f)
                )

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward arrow",
                    modifier = Modifier.padding(start = 5.dp, top = 10.dp),
                    tint = Color.Gray
                )
            }
        }
    }
}

@Composable
fun EleventhCard(card : CardItem.EleventhCard) {
    Card(
        modifier = Modifier
            .padding(
                start = 10.dp, top = 13.dp, end = 10.dp
            )
            .fillMaxWidth()
            .height(300.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {

        Column {
            Row {
                VerticalDivider(
                    thickness = 3.dp,
                    modifier = Modifier
                        .height(34.dp)
                        .padding(top = 12.dp)
                        .clip(shape = RoundedCornerShape(10.dp)),
                    color = colorResource(R.color.purple_500)
                )

                Text(
                    text = "More",
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 10.dp, top = 10.dp)
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "Your ordrr",
                    modifier = Modifier.padding(start = 5.dp, top  = 10.dp),
                    tint = Color.LightGray
                )
                Text(
                    text = "About",
                    color = Color.Black,
                    modifier = Modifier
                        .padding(start = 5.dp, top = 10.dp)
                        .weight(1f)
                )

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward arrow",
                    modifier = Modifier.padding(start = 5.dp, top = 10.dp),
                    tint = Color.Gray
                )
            }

            HorizontalDivider(
                thickness = 0.5.dp,
                modifier = Modifier
                    .padding(start = 53.dp, top = 10.dp)
                    .weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painterResource(R.drawable.feedback),
                    contentDescription = "Your order",
                    modifier = Modifier.padding(start = 5.dp),
                    tint = Color.LightGray
                )
                Text(
                    text = "Send feedback",
                    color = Color.Black,
                    modifier = Modifier
                        .padding(start = 5.dp, top = 10.dp)
                        .weight(1f)
                )

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward arrow",
                    modifier = Modifier.padding(start = 5.dp, top = 10.dp),
                    tint = Color.Gray
                )
            }
            HorizontalDivider(
                thickness = 0.5.dp,
                modifier = Modifier
                    .padding(start = 53.dp, top = 10.dp)
                    .weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "Your ordrr",
                    modifier = Modifier.padding(start = 5.dp),
                    tint = Color.LightGray
                )
                Text(
                    text = "Report a safety emergency",
                    color = Color.Black,
                    modifier = Modifier
                        .padding(start = 5.dp, top = 10.dp)
                        .weight(1f)
                )

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward arrow",
                    modifier = Modifier.padding(start = 5.dp, top = 10.dp),
                    tint = Color.Gray
                )
            }
            HorizontalDivider(
                thickness = 0.5.dp,
                modifier = Modifier
                    .padding(start = 53.dp, top = 10.dp)
                    .weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Your ordrr",
                    modifier = Modifier.padding(start = 5.dp),
                    tint = Color.LightGray
                )
                Text(
                    text = "Settings",
                    color = Color.Black,
                    modifier = Modifier
                        .padding(start = 5.dp, top = 10.dp)
                        .weight(1f)
                )

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward arrow",
                    modifier = Modifier.padding(start = 5.dp, top = 10.dp),
                    tint = Color.Gray
                )
            }
            HorizontalDivider(
                thickness = 0.5.dp,
                modifier = Modifier
                    .padding(start = 53.dp, top = 10.dp)
                    .weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painterResource(R.drawable.logout),
                    contentDescription = "Your ordrr",
                    modifier = Modifier.padding(start = 5.dp),
                    tint = Color.LightGray
                )
                Text(
                    text = "Logout",
                    color = Color.Black,
                    modifier = Modifier
                        .padding(start = 5.dp, top = 10.dp)
                        .weight(1f)
                )

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward arrow",
                    modifier = Modifier.padding(start = 5.dp, top = 10.dp),
                    tint = Color.Gray
                )
            }

        }
    }
    
}

sealed class CardItem {

    data class ColoumnGrid(val name: String) : CardItem()
    data class FirstCard(val Profilename: String, val percentagetext: String) : CardItem()
    data class SecondCard(val vegtext: String) : CardItem()
    data class ThirdCard(val Appearance: String) : CardItem()
    data class FourthCard(val rating: String) : CardItem()
    data class FifthCard(val Food_Order: String) : CardItem()
    data class SixthCard(val Titilename: String) : CardItem()
    data class SeventhCard(val title: String) : CardItem()
    data class EighthCard(val Title: String) : CardItem()
    data class NinthCard(val Title: String) : CardItem()
    data class TenCard(val Title: String) : CardItem()
    data class EleventhCard(val Title: String) : CardItem()
}

