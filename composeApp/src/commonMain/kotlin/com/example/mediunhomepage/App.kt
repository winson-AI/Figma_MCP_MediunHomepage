package com.example.mediunhomepage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import mediunhomepage.composeapp.generated.resources.Res
import mediunhomepage.composeapp.generated.resources.ic_battery
import mediunhomepage.composeapp.generated.resources.ic_bell
import org.jetbrains.compose.resources.DrawableResource
import mediunhomepage.composeapp.generated.resources.ic_category_meal
import mediunhomepage.composeapp.generated.resources.ic_category_dessert
import mediunhomepage.composeapp.generated.resources.ic_category_vegan
import mediunhomepage.composeapp.generated.resources.ic_category_drinks
import mediunhomepage.composeapp.generated.resources.ic_category_snacks
import mediunhomepage.composeapp.generated.resources.ic_chat
import mediunhomepage.composeapp.generated.resources.ic_heart
import mediunhomepage.composeapp.generated.resources.ic_home
import mediunhomepage.composeapp.generated.resources.ic_list
import mediunhomepage.composeapp.generated.resources.ic_meal
import mediunhomepage.composeapp.generated.resources.ic_profile
import mediunhomepage.composeapp.generated.resources.ic_shop
import mediunhomepage.composeapp.generated.resources.img_promo_pizza
import mediunhomepage.composeapp.generated.resources.img_best_seller_1
import mediunhomepage.composeapp.generated.resources.img_best_seller_2
import mediunhomepage.composeapp.generated.resources.img_best_seller_3
import mediunhomepage.composeapp.generated.resources.img_best_seller_4
import mediunhomepage.composeapp.generated.resources.img_recommend_1
import mediunhomepage.composeapp.generated.resources.img_recommend_2
import mediunhomepage.composeapp.generated.resources.ic_signal
import mediunhomepage.composeapp.generated.resources.ic_wifi

@Composable
@Preview
fun App() {
    MaterialTheme {
        Surface(color = Color(0xFFF5CB58)) { // page background from Figma
            Box(modifier = Modifier.fillMaxSize()) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .safeContentPadding()
                        .verticalScroll(rememberScrollState())
                        .padding(bottom = 16.dp)
                ) {
                    TopStatusBar()
                    Spacer(Modifier.height(14.dp))
                    TopSearchRow()
                    Spacer(Modifier.height(18.dp))
                    HeaderTexts()

                    Spacer(Modifier.height(24.dp))
                    CategoryRow()

                    Spacer(Modifier.height(16.dp))
                    DividerLine()

                    Spacer(Modifier.height(12.dp))
                    BestSellerHeader()
                    Spacer(Modifier.height(10.dp))
                    BestSellerGrid()

                    Spacer(Modifier.height(18.dp))
                    PromoBanner()

                    Spacer(Modifier.height(18.dp))
                    RecommendHeader()
                    Spacer(Modifier.height(10.dp))
                    RecommendRow()

                    Spacer(Modifier.height(80.dp)) // bottom nav spacing placeholder
                }

                BottomNavBar()
            }
        }
    }
}

@Composable
private fun TopStatusBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(32.dp)
            .background(Color(0xFFF5CB58))
    ) {
        Text(
            text = "16:04",
            color = Color(0xFF391713),
            fontSize = 13.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.align(Alignment.CenterStart).padding(start = 35.dp)
        )
        // Right-side system icons omitted; keep layout space
        Row(
            modifier = Modifier.align(Alignment.CenterEnd).padding(end = 35.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            PlaceholderIcon(size = 16.dp, icon = Res.drawable.ic_signal)
            Spacer(Modifier.width(8.dp))
            PlaceholderIcon(size = 16.dp, icon = Res.drawable.ic_wifi)
            Spacer(Modifier.width(8.dp))
            PlaceholderIcon(size = 16.dp, icon= Res.drawable.ic_battery)
        }
    }
}

@Composable
private fun TopSearchRow() {
    Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 36.dp), verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .weight(1f)
                .height(26.dp)
                .clip(RoundedCornerShape(30.dp))
                .background(Color.White)
                .padding(horizontal = 12.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = "Search",
                color = Color(0xFF676767),
                fontSize = 12.sp,
                fontWeight = FontWeight.Light
            )
            Box(
                modifier = Modifier.align(Alignment.CenterEnd)
                    .size(20.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFE95322))
            )
        }
        Spacer(Modifier.width(8.dp))
        SmallSquare(icon = Res.drawable.ic_shop)
        Spacer(Modifier.width(8.dp))
        SmallSquare(icon = Res.drawable.ic_bell)
        Spacer(Modifier.width(8.dp))
        SmallSquare(icon = Res.drawable.ic_profile)
    }
}

@Composable
private fun HeaderTexts() {
    Column(modifier = Modifier.padding(horizontal = 34.dp)) {
        Text(
            text = "Good Morning",
            color = Color(0xFFF8F8F8),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(2.dp))
        Text(
            text = "Rise and shine! It's breakfast time",
            color = Color(0xFFE95322),
            fontSize = 13.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
private fun CategoryRow() {
    Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 18.dp), horizontalArrangement = Arrangement.spacedBy(28.dp)) {
        CategoryItem(label = "Snacks", icon = Res.drawable.ic_category_snacks)
        CategoryItem(label = "Meal", icon = Res.drawable.ic_category_meal)
        CategoryItem(label = "Vegan", icon = Res.drawable.ic_category_vegan)
        CategoryItem(label = "Dessert", icon = Res.drawable.ic_category_dessert)
        CategoryItem(label = "Drinks", icon = Res.drawable.ic_category_drinks)
    }
}

@Composable
private fun DividerLine() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 35.dp)
            .height(1.dp)
            .background(Color(0xFFFFD8C7))
    )
}

@Composable
private fun BestSellerHeader() {
    Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 35.dp), verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = "Best Seller",
            color = Color(0xFF391713),
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = "View All",
            color = Color(0xFFE95322),
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
private fun BestSellerGrid() {
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 35.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        BestSellerCard(image = Res.drawable.img_best_seller_1, price = "$103.0")
        BestSellerCard(image = Res.drawable.img_best_seller_2, price = "$50.0")
        BestSellerCard(image = Res.drawable.img_best_seller_3, price = "$12.99")
        BestSellerCard(image = Res.drawable.img_best_seller_4, price = "$8.20")
    }
}

@Composable
private fun PromoBanner() {
    Box(
        modifier = Modifier
            .padding(horizontal = 35.dp)
            .height(128.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xFFE95322))
    ) {
        // Decorative circles similar to Figma
        Box(
            modifier = Modifier
                .size(55.dp)
                .align(Alignment.TopStart)
                .offset(x = 106.dp, y = (-37).dp)
                .border(2.dp, Color(0xFFF5CB58), CircleShape)
        )
        Box(
            modifier = Modifier
                .size(46.dp)
                .align(Alignment.BottomStart)
                .offset(x = (-14).dp, y = 105.dp)
                .border(2.dp, Color(0xFFF5CB58), CircleShape)
        )

        Column(modifier = Modifier.align(Alignment.CenterStart).padding(start = 14.dp)) {
            Text(
                text = "Experience our delicious new dish",
                color = Color(0xFFF8F8F8),
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                modifier = Modifier.width(140.dp)
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = "30% OFF",
                color = Color(0xFFF8F8F8),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
        }

        // Photo on the right
        Image(
            painter = painterResource(Res.drawable.img_promo_pizza),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .fillMaxHeight()
                .width(180.dp)
                .clip(RoundedCornerShape(topEnd = 20.dp, bottomEnd = 20.dp))
        )
    }
}

@Composable
private fun RecommendHeader() {
    Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 35.dp), verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = "Recommend",
            color = Color(0xFF391713),
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
private fun RecommendRow() {
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 35.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        RecommendCard(image = Res.drawable.img_recommend_1, price = "$10.0")
        RecommendCard(image = Res.drawable.img_recommend_2, price = "$25.0")
    }
}

@Composable
private fun SmallSquare(icon: org.jetbrains.compose.resources.DrawableResource) {
    Box(
        modifier = Modifier
            .size(26.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0xFFF8F8F8)),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(icon),
            contentDescription = null,
            modifier = Modifier.size(12.dp)
        )
    }
}

@Composable
private fun PlaceholderIcon(size: Dp, icon: org.jetbrains.compose.resources.DrawableResource? = null) {
    Box(
        modifier = Modifier
            .size(size)
            .clip(RoundedCornerShape(2.dp))
            .background(Color.Transparent)
    ) {
        if (icon != null) {
            Image(
                painter = painterResource(icon),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        } else {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(2.dp))
                    .background(Color(0xFFAAAAAA))
            )
        }
    }
}

@Composable
private fun CategoryItem(label: String, icon: org.jetbrains.compose.resources.DrawableResource) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .size(49.dp, 62.dp)
                .clip(RoundedCornerShape(30.dp))
                .background(Color(0xFFF3E9B5)),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(icon),
                contentDescription = label,
                modifier = Modifier.size(24.dp)
            )
        }
        Spacer(Modifier.height(8.dp))
        Text(text = label, color = Color(0xFF391713), fontSize = 12.sp)
    }
}

@Composable
private fun BestSellerCard(image: org.jetbrains.compose.resources.DrawableResource, price: String) {
    Box(
        modifier = Modifier
            .size(width = 72.dp, height = 108.dp)
            .clip(RoundedCornerShape(19.dp))
            .background(Color.LightGray)
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        PriceTag(text = price, modifier = Modifier.align(Alignment.BottomCenter).offset(y = 8.dp))
    }
}

@Composable
private fun RecommendCard(image: org.jetbrains.compose.resources.DrawableResource, price: String) {
    Box(
        modifier = Modifier
            .size(width = 159.dp, height = 140.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color.LightGray)
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Row(
            modifier = Modifier.align(Alignment.TopStart).padding(top = 10.dp, start = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            PriceTag(text = price)
            Spacer(Modifier.width(8.dp))
            Box(
                modifier = Modifier
                    .size(14.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color(0xFFF8F8F8))
            )
        }

        Pill(text = "5.0", modifier = Modifier.align(Alignment.CenterStart).padding(start = 12.dp))
    }
}

@Composable
private fun PriceTag(text: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(30.dp))
            .background(Color(0xFFE95322))
            .padding(horizontal = 8.dp, vertical = 2.dp)
    ) {
        Text(text = text, color = Color.White, fontSize = 12.sp)
    }
}

@Composable
private fun Pill(text: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(30.dp))
            .background(Color.White)
            .padding(horizontal = 8.dp, vertical = 2.dp)
    ) {
        Text(text = text, color = Color(0xFF391713), fontSize = 12.sp)
    }
}

@Composable
private fun BoxScope.BottomNavBar() {
    Box(
        modifier = Modifier
            .align(Alignment.BottomCenter)
            .fillMaxWidth()
            .height(61.dp)
            .background(Color(0xFFE95322))
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            PlaceholderIcon(size = 22.dp, icon = Res.drawable.ic_home)
            PlaceholderIcon(size = 22.dp, icon = Res.drawable.ic_meal)
            PlaceholderIcon(size = 22.dp, icon = Res.drawable.ic_heart)
            PlaceholderIcon(size = 22.dp, icon = Res.drawable.ic_list)
            PlaceholderIcon(size = 22.dp, icon = Res.drawable.ic_chat)
        }
    }
}