package com.example.mediunhomepage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mediunhomepage.composeapp.generated.resources.Res
import mediunhomepage.composeapp.generated.resources.action_bell
import mediunhomepage.composeapp.generated.resources.action_cart
import mediunhomepage.composeapp.generated.resources.banner_pizza
import mediunhomepage.composeapp.generated.resources.best_seller_card_1
import mediunhomepage.composeapp.generated.resources.best_seller_card_2
import mediunhomepage.composeapp.generated.resources.best_seller_card_3
import mediunhomepage.composeapp.generated.resources.best_seller_card_4
import mediunhomepage.composeapp.generated.resources.bot_dessert
import mediunhomepage.composeapp.generated.resources.bot_drinks
import mediunhomepage.composeapp.generated.resources.bot_meal
import mediunhomepage.composeapp.generated.resources.bot_snacks
import mediunhomepage.composeapp.generated.resources.bot_vegan
import mediunhomepage.composeapp.generated.resources.heart_badge
import mediunhomepage.composeapp.generated.resources.nav_bell
import mediunhomepage.composeapp.generated.resources.nav_book
import mediunhomepage.composeapp.generated.resources.nav_explore
import mediunhomepage.composeapp.generated.resources.nav_heart
import mediunhomepage.composeapp.generated.resources.nav_home
import mediunhomepage.composeapp.generated.resources.next_icon_arrow
import mediunhomepage.composeapp.generated.resources.recommend_card_1
import mediunhomepage.composeapp.generated.resources.recommend_card_2
import mediunhomepage.composeapp.generated.resources.search_filter_icon
import mediunhomepage.composeapp.generated.resources.search_user_icon
import mediunhomepage.composeapp.generated.resources.star_small
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

private val ColorTextDark = Color(0xFF391713)
private val ColorTextLight = Color(0xFFF8F8F8)
private val ColorOrange = Color(0xFFE95322)
private val ColorYellow2 = Color(0xFFF3E9B5)
private val ColorBgYellow = Color(0xFFF5CB58)
private val ColorChipBg = Color(0xFFF8F8F8)

@OptIn(ExperimentalResourceApi::class)
@Preview
@Composable
fun App() {
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = ColorBgYellow) {
            Box(Modifier.fillMaxSize()) {
                // Main rounded container (content area)
                Box(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(top = 161.dp)
                        .fillMaxWidth()
                        .height(689.dp)
                        .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                        .background(Color(0xFFF5F5F5))
                ) {}

                // Top bar: time + search + actions
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp)
                ) {
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(
                            text = "16:04",
                            color = ColorTextDark,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.padding(start = 35.dp)
                        )
                        // Right side status icons omitted for brevity
                        Spacer(Modifier.width(35.dp))
                    }

                    Row(
                        modifier = Modifier
                            .padding(top = 18.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Search pill
                        Box(
                            modifier = Modifier
                                .padding(start = 36.dp)
                                .clip(RoundedCornerShape(30.dp))
                                .background(Color.White)
                                .height(26.dp)
                                .width(200.dp)
                                .padding(horizontal = 12.dp),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text("Search", color = Color(0xFF676767), fontSize = 12.sp)
                                Spacer(Modifier.weight(1f))
                                Image(
                                    painter = painterResource(Res.drawable.search_filter_icon),
                                    contentDescription = null,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        }

                        Spacer(Modifier.weight(1f))

                        // Three action squares (cart, bell, user)
                        Row(modifier = Modifier.padding(end = 35.dp)) {
                            ActionSquare(icon = Res.drawable.action_cart)
                            Spacer(Modifier.width(7.dp))
                            ActionSquare(icon = Res.drawable.action_bell)
                            Spacer(Modifier.width(7.dp))
                            ActionSquare(icon = Res.drawable.search_user_icon)
                        }
                    }
                }

                // Greeting
                Column(modifier = Modifier.padding(top = 104.dp, start = 34.dp)) {
                    Text("Good Morning", color = ColorTextLight, fontSize = 30.sp, fontWeight = FontWeight.Bold)
                    Spacer(Modifier.height(4.dp))
                    Text("Rise and shine! It's breakfast time", color = ColorOrange, fontSize = 13.sp, fontWeight = FontWeight.Medium)
                }

                // Bot-menu categories
                Row(
                    modifier = Modifier
                        .padding(top = 190.dp, start = 35.dp, end = 35.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(24.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CategoryChip(iconRes = Res.drawable.bot_meal, label = "Meal")
                    CategoryChip(iconRes = Res.drawable.bot_dessert, label = "Dessert")
                    CategoryChip(iconRes = Res.drawable.bot_vegan, label = "Vegan")
                    CategoryChip(iconRes = Res.drawable.bot_drinks, label = "Drinks")
                    CategoryChip(iconRes = Res.drawable.bot_snacks, label = "Snacks")
                }

                // Best Seller header
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 295.dp, start = 35.dp, end = 35.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Best Seller", color = ColorTextDark, fontSize = 20.sp, fontWeight = FontWeight.Medium)
                    Text("View All", color = ColorOrange, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                }

                // Divider line
                Box(
                    modifier = Modifier
                        .padding(top = 281.dp, start = 35.dp, end = 35.dp)
                        .height(1.dp)
                        .fillMaxWidth()
                        .background(Color(0x22000000))
                )

                // Best Seller grid (4 items)
                Row(
                    modifier = Modifier
                        .padding(top = 324.dp, start = 36.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(11.dp)
                ) {
                    SmallCard(imageRes = Res.drawable.best_seller_card_1, price = "$103.0")
                    SmallCard(imageRes = Res.drawable.best_seller_card_2, price = "$50.0")
                    SmallCard(imageRes = Res.drawable.best_seller_card_3, price = "$12.99")
                    SmallCard(imageRes = Res.drawable.best_seller_card_4, price = "$8.20")
                }

                // Next Icon Arrow near Best Seller
                Image(
                    painter = painterResource(Res.drawable.next_icon_arrow),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 300.dp, end = 35.dp)
                        .align(Alignment.TopEnd)
                        .size(width = 8.dp, height = 13.dp)
                )

                // Promo banner with pizza image
                PromoBanner(
                    modifier = Modifier
                        .padding(top = 452.dp, start = 35.dp)
                        .width(323.dp)
                        .height(128.dp)
                        .clip(RoundedCornerShape(20.dp)),
                    rightImageRes = Res.drawable.banner_pizza
                )

                // Recommend header
                Text(
                    text = "Recommend",
                    color = ColorTextDark,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(top = 610.dp, start = 35.dp)
                )

                // Recommend row (2 items)
                Row(
                    modifier = Modifier
                        .padding(top = 645.dp, start = 34.dp, end = 34.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(7.dp)
                ) {
                    RecommendCard(
                        imageRes = Res.drawable.recommend_card_1,
                        rating = "5.0",
                        price = "$10.0"
                    )
                    RecommendCard(
                        imageRes = Res.drawable.recommend_card_2,
                        rating = "5.0",
                        price = "$25.0"
                    )
                }

                // Frame 56 footer navigation
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth()
                        .height(61.dp)
                        .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                        .background(ColorOrange)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 28.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(painter = painterResource(Res.drawable.nav_home), contentDescription = null, modifier = Modifier.size(25.dp))
                        Image(painter = painterResource(Res.drawable.nav_explore), contentDescription = null, modifier = Modifier.size(31.dp))
                        Image(painter = painterResource(Res.drawable.nav_heart), contentDescription = null, modifier = Modifier.size(21.dp))
                        Image(painter = painterResource(Res.drawable.nav_book), contentDescription = null, modifier = Modifier.size(25.dp))
                        Image(painter = painterResource(Res.drawable.nav_bell), contentDescription = null, modifier = Modifier.size(24.dp))
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun ActionSquare(size: Dp = 26.dp, icon: DrawableResource? = null) {
    Box(
        modifier = Modifier
            .size(size)
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0xFFF8F8F8)),
        contentAlignment = Alignment.Center
    ) {
        if (icon != null) {
            Image(painter = painterResource(icon), contentDescription = null, modifier = Modifier.size((size.value * 0.6f).dp))
        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun CategoryChip(iconRes: DrawableResource, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(30.dp))
                .background(ColorYellow2)
                .width(49.dp)
                .height(62.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(painter = painterResource(iconRes), contentDescription = null, modifier = Modifier.size(24.dp))
        }
        Spacer(Modifier.height(6.dp))
        Text(label, color = ColorTextDark, fontSize = 12.sp)
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun SmallCard(imageRes: DrawableResource, price: String) {
    Box(modifier = Modifier.width(71.681.dp).height(108.dp)) {
        Image(
            painter = painterResource(imageRes),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(20.dp)),
            contentScale = ContentScale.Crop
        )
        // Price chip
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 35.dp, y = 80.dp)
                .clip(RoundedCornerShape(topStart = 30.dp, bottomStart = 30.dp))
                .background(ColorOrange)
                .height(16.dp)
                .width(38.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(price, color = Color.White, fontSize = 12.sp)
        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun PromoBanner(modifier: Modifier, rightImageRes: DrawableResource) {
    Box(
        modifier = modifier
            .background(Color(0xFF391713))
    ) {
        // Decorative swoosh background (approximation of Figma vector)
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .offset(y = 8.dp)
                .fillMaxWidth()
                .height(110.dp)
                .clip(RoundedCornerShape(topStart = 90.dp, topEnd = 24.dp))
                .background(ColorYellow2.copy(alpha = 0.35f))
        )

        // Right image
        Image(
            painter = painterResource(rightImageRes),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .width(212.dp)
                .height(141.dp)
        )

        // Accent circles per Figma (Ellipse 13 and 12)
        Box(
            modifier = Modifier
                .size(55.dp)
                .align(Alignment.TopStart)
                .offset(x = 106.dp, y = (-37).dp)
                .clip(CircleShape)
                .background(ColorYellow2.copy(alpha = 0.55f))
        )
        Box(
            modifier = Modifier
                .size(46.dp)
                .align(Alignment.TopStart)
                .offset(x = (-14).dp, y = 105.dp)
                .clip(CircleShape)
                .background(ColorYellow2.copy(alpha = 0.55f))
        )

        Column(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 16.dp)
        ) {
            Text(
                text = "Experience our delicious new dish",
                color = ColorTextLight,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.width(140.dp)
            )
            Spacer(Modifier.height(6.dp))
            Text(
                text = "30% OFF",
                color = ColorTextLight,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun RecommendCard(imageRes: DrawableResource, rating: String, price: String) {
    Box(
        modifier = Modifier
            .width(159.dp)
            .height(140.dp)
    ) {
        Image(
            painter = painterResource(imageRes),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(20.dp)),
            contentScale = ContentScale.Crop
        )

        // Favorite heart badge
        Image(
            painter = painterResource(Res.drawable.heart_badge),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .offset(x = (-17).dp, y = 10.dp)
                .size(14.dp)
        )

        // Rating chip
        Row(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 13.dp, y = 10.dp)
                .clip(RoundedCornerShape(30.dp))
                .background(Color.White)
                .height(14.dp)
                .padding(horizontal = 6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(rating, color = ColorTextDark, fontSize = 12.sp)
            Spacer(Modifier.width(4.dp))
            Image(
                painter = painterResource(Res.drawable.star_small),
                contentDescription = null,
                modifier = Modifier.size(9.dp)
            )
        }

        // Price chip
        Box(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .offset(x = 13.dp, y = (-12).dp)
                .clip(RoundedCornerShape(topStart = 30.dp, bottomStart = 30.dp))
                .background(ColorOrange)
                .height(16.dp)
                .padding(horizontal = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(price, color = Color.White, fontSize = 12.sp)
        }
    }
}