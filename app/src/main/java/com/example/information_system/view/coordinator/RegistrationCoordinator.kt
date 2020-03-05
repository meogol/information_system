package com.example.information_system.view.coordinator;

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import com.example.information_system.view.activity.MainActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.vk.sdk.VKAccessToken
import com.vk.sdk.VKCallback
import com.vk.sdk.VKScope
import com.vk.sdk.VKSdk
import com.vk.sdk.api.VKError

public class RegistrationCoordinator {
    fun checkAuth(context: Context) {
        if (VKSdk.isLoggedIn()) {
            newActivity(context)
        } else if (GoogleSignIn.getLastSignedInAccount(context) != null) {
            newActivity(context)
        }
    }

    inner class VKAuth() {
        fun signIn(mainActivity: Activity) {
            VKSdk.login(mainActivity, VKScope.FRIENDS)
            // getInfo()
        }

        /*fun getInfo() {
            val a = VKApi.friends().get(
                VKParameters.from(
                    VKApiConst.FIELDS,
                    "id,first_name,last_name,photo_100,photo_max_orig,online,status"
                )
            )
            a.executeWithListener(object : VKRequest.VKRequestListener() {
                override fun onComplete(response: VKResponse?) {
                    super.onComplete(response)
                    val list = response!!.parsedModel as VKList<*>
                    val s = list[0].fields.toString()
                    Log.e("friends", s)

                }
            })
        }*/
    }

     public inner class GoogleAuth() {
        lateinit var mGoogleSignInClient: GoogleSignInClient

        fun initGSO(): GoogleSignInOptions? {
                val gso =
                GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                        .requestEmail()
                        .build()
        return gso
        }

        fun signIn( context: Context,  mainActivity: Activity) {
            val gso = initGSO()
            mGoogleSignInClient = GoogleSignIn.getClient(context, gso!!)
            startGoogleActivity(mGoogleSignInClient, mainActivity)
        }

        fun handleSignInResult(completedTask: Task<GoogleSignInAccount>, context: Context) {
            try {
                val account = completedTask.getResult(ApiException::class.java)
                Log.e("account", account.toString())
                newActivity(context)
                Log.e("name", account!!.idToken)
            } catch (e: ApiException) {
                Log.e("fail", "signInResult:failed code=" + e.getStatusCode()); }
        }
    }

    fun newActivity(context: Context){
        val intent = Intent(context, MainActivity::class.java)
        context.startActivity(intent)
    }
    fun startGoogleActivity(mGoogleSignInClient:GoogleSignInClient,mainActivity:Activity){
        val signInIntent: Intent = mGoogleSignInClient.signInIntent
        mainActivity.startActivityForResult(signInIntent, 1)
    }

    fun resultAuth(context: Context, requestCode: Int, resultCode: Int, data: Intent?) {
        if (!VKSdk.onActivityResult(
                requestCode,
                resultCode,
                data,
                object : VKCallback<VKAccessToken> {
                    override fun onResult(res: VKAccessToken?) {
                        Log.e("vk", "success")
                        Log.e("vktoken", res!!.accessToken!!.toString())
                        newActivity(context)
                    }

                    override fun onError(error: VKError?) {
                        Log.e("vk", "error $requestCode")
                    }
                })
        )

        if (requestCode == 1) {
            Log.e("result code", resultCode.toString())
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
            GoogleAuth().handleSignInResult(task, context)
        }

    }
}
