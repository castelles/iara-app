package castelles.com.github.iaraapp

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.Group
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import castelles.com.github.iaraapp.app.GlideApp
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.request.transition.Transition
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private var client: GoogleSignInClient? = null
    private lateinit var navigationView: NavigationView
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private val user: GoogleSignInAccount? by lazy {
        GoogleSignIn.getLastSignedInAccount(this)
    }

    private val signInActivityLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            try {
                val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
                handleSigInResult(task)
            } catch (e: ApiException) { }
        }
    }

    override fun onStart() {
        super.onStart()
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestProfile()
            .build()
        client = GoogleSignIn.getClient(this, gso)
    }

    override fun onResume() {
        super.onResume()
        setNavigation()
    }
    private fun setNavigation() {
        navController = (supportFragmentManager.findFragmentById(R.id.nav_host_main)
                as NavHostFragment).navController
        val drawerLayout = setAppBarConfiguration()
        setNavigationView(drawerLayout)
    }

    private fun setNavigationView(drawerLayout: DrawerLayout?) {
        navigationView = findViewById<NavigationView?>(R.id.nav_view).also {
            it.setNavigationItemSelectedListener {item ->
                drawerLayout?.closeDrawer(GravityCompat.START)
                item.onNavDestinationSelected(navController)
                true
            }
            it.setupWithNavController(navController)
            it.setDrawerHeaderLayout(user)
        }
    }

    private fun NavigationView.setDrawerHeaderLayout(account: GoogleSignInAccount?) {
        val header = getHeaderView(0)
        setAccountLayout(account, header)
    }

    private fun NavigationView.setAccountLayout(
        account: GoogleSignInAccount?,
        header: View
    ) {
        account?.let { acc ->
            header.findViewById<TextView>(R.id.txv_user_name).text = acc.displayName
            val userImageView = header.findViewById<ImageView>(R.id.imv_user)
            GlideApp.with(this)
                .asBitmap()
                .load(acc.photoUrl.toString())
                .placeholder(R.drawable.account_circle_40px)
                .into(object : CustomTarget<Bitmap>() {
                    override fun onResourceReady(
                        resource: Bitmap,
                        transition: Transition<in Bitmap>?
                    ) {
                        userImageView.imageTintMode = null
                        userImageView.setImageBitmap(resource)
                    }

                    override fun onLoadCleared(placeholder: Drawable?) {}
                })
        } ?: run {
            header.findViewById<Group>(R.id.group_logged_user).visibility = GONE
            header.findViewById<SignInButton>(R.id.sgn_btn)?.run {
                visibility = VISIBLE
                setSize(SignInButton.SIZE_STANDARD)
                setOnClickListener {
                    val intent = client?.signInIntent
                    signInActivityLauncher.launch(intent)
                }
            }
        }
    }

    private fun setAppBarConfiguration(): DrawerLayout {
        val drawerLayout: DrawerLayout = findViewById(R.id.dl_root)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.main,
                R.id.place,
                R.id.places,
            ),
            drawerLayout
        )
        return drawerLayout
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    private fun handleSigInResult(task: Task<GoogleSignInAccount>) {
        val account = task.result
        navigationView.setDrawerHeaderLayout(account)
    }
}
