package com.example.komatoapp.presentation.screens

import android.provider.ContactsContract
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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
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
import androidx.compose.runtime.mutableStateSetOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.komatoapp.R

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
fun ColumnGrid(card: cardItem.ColoumnGrid) {
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
fun Lazycoloumm() {
    val cardList = listOf(
        cardItem.ColoumnGrid(name = "Ayush"),
        cardItem.FirstCard(Profilename = "Your Profile", percentagetext = "48%Completed"),
        cardItem.SecondCard(vegtext = "Veg Mode"),
        cardItem.ThirdCard(Appearance = "Appearance"),
        cardItem.FourthCard(rating = "Your rating"),
        cardItem.FifthCard(Food_Order = "Food Orders"),
        cardItem.SixthCard(Titilename = "Dining and Experience"),
        cardItem.SeventhCard(title = "done"),
        cardItem.EighthCard(Title = "done"),
        cardItem.NinthCard(Title = "done"),
        cardItem.TenCard(Title = "done"),
        cardItem.EleventhCard(Title = "eleventhdone")
    )

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(cardList) { item ->

            when (item) {
                is cardItem.ColoumnGrid -> ColumnGrid(item)
                is cardItem.FirstCard -> ProductCard(item)
                is cardItem.SecondCard ->
            }
        }
    }
}

@Composable
fun ProductCard(card: cardItem.FirstCard) {
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
fun VegModeCard(card: cardItem.SecondCard) {
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
fun AppearanceCard(card: cardItem.ThirdCard) {
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
fun RatingCard(card: cardItem.FourthCard) {

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
fun FoodOrderCard(card: cardItem.FifthCard) {

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

            HorizontalDivider(thickness = 0.5.dp,
                modifier = Modifier.padding(start = 53.dp,top = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f))


            Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically) {

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

            HorizontalDivider(thickness = 0.5.dp,
                modifier = Modifier.padding(start = 53.dp,top = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f))


            Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically) {

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


sealed class cardItem {

    data class ColoumnGrid(val name: String) : cardItem()
    data class FirstCard(val Profilename: String, val percentagetext: String) : cardItem()
    data class SecondCard(val vegtext: String) : cardItem()
    data class ThirdCard(val Appearance: String) : cardItem()
    data class FourthCard(val rating: String) : cardItem()
    data class FifthCard(val Food_Order: String) : cardItem()
    data class SixthCard(val Titilename: String) : cardItem()
    data class SeventhCard(val title: String) : cardItem()
    data class EighthCard(val Title: String) : cardItem()
    data class NinthCard(val Title: String) : cardItem()
    data class TenCard(val Title: String) : cardItem()
    data class EleventhCard(val Title: String) : cardItem()
}
