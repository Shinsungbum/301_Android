package com.example.project03_last.member;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.project03_last.MainActivity;
import com.example.project03_last.R;
import com.example.project03_last.common.CommonVal;
import com.example.project03_last.conn.CommonConn;
import com.google.gson.Gson;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.user.UserApiClient;
import com.navercorp.nid.NaverIdLoginSDK;
import com.navercorp.nid.oauth.NidOAuthLogin;
import com.navercorp.nid.oauth.OAuthLoginCallback;
import com.navercorp.nid.oauth.view.NidOAuthLoginButton;
import com.navercorp.nid.profile.NidProfileCallback;
import com.navercorp.nid.profile.data.NidProfileResponse;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;

public class LoginActivity extends AppCompatActivity {
    NidOAuthLoginButton btn_naver;
    EditText edt_email, edt_pw;
    Button btn_login, btn_join;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //NaverIdLoginSDK.initialize(context, {OAUTH_CLIENT_ID}, {OAUTH_CLIENT_SECRET}, {OAUTH_CLIENT_NAME})
        //코틀린은 객체를 인스턴스화 안해도 자동으로 안에있는 인스턴스 멤버를 접근해서 쓸수가있음
        //함수지향.

        getHashKey();



        NaverIdLoginSDK.INSTANCE.initialize(this,
                "r1UGjxZ0flGNxHfqq6G2",
                "1TKoJFdRHP",
                "Project03_Last");

        btn_naver = findViewById(R.id.btn_naver);
        edt_email = findViewById(R.id.edt_email);
        edt_pw = findViewById(R.id.edt_pw);
        btn_login = findViewById(R.id.btn_login);
        btn_join = findViewById(R.id.btn_join);

        btn_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, JoinActivity.class);
                startActivity(intent);
            }
        });




        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //아이디 비밀번호 입력체크 나중에 넣어야함.
                login(edt_email.getText() + "", edt_pw.getText()+"");
            }
        });







        btn_naver.setOAuthLoginCallback(new OAuthLoginCallback() {
            @Override
            public void onSuccess() {
                Log.d("네이버", "onSuccess: " + NaverIdLoginSDK.INSTANCE.getAccessToken());
                naver_profile();

            }

            @Override
            public void onFailure(int i, @NonNull String s) {
                Log.d("네이버", "onFailure: ");
            }

            @Override
            public void onError(int i, @NonNull String s) {
                Log.d("네이버", "onError: ");
            }
        });

        KakaoSdk.init(this, "cfec71d35218ae0481b62debc9b42e60");
        findViewById(R.id.btn_kakao).setOnClickListener( v -> {

        });


        //lamda식 자바코드를 함수형으로 간편하게 줄여서 사용한것
        findViewById(R.id.btn_kakao).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Function2<OAuthToken, Throwable , Unit> callback = new Function2<OAuthToken, Throwable, Unit>() {
                    @Override
                    public Unit invoke(OAuthToken oAuthToken, Throwable throwable) {
                        if (oAuthToken != null){
                            Log.d("토큰", "invoke: 받아옴");
                            kakao_profile();
                        }

                        if (throwable != null){
                            Log.d("토큰", "invoke: 오류있음");
                        }
                        return null;
                    }
                };



                UserApiClient apiClient = new UserApiClient();
                if (apiClient.isKakaoTalkLoginAvailable(LoginActivity.this)){
                    apiClient.loginWithKakaoAccount(LoginActivity.this, callback);
                }else{
                    apiClient.loginWithKakaoAccount(LoginActivity.this, callback);
                }
                /*
                // 카카오톡이 설치되어 있으면 카카오톡으로 로그인, 아니면 카카오계정으로 로그인
                if (UserApiClient.instance.isKakaoTalkLoginAvailable(context)) {
                    UserApiClient.instance.loginWithKakaoTalk(context) { token, error ->
                        if (error != null) {
                            Log.e(TAG, "카카오톡으로 로그인 실패", error)

                            // 사용자가 카카오톡 설치 후 디바이스 권한 요청 화면에서 로그인을 취소한 경우,
                            // 의도적인 로그인 취소로 보고 카카오계정으로 로그인 시도 없이 로그인 취소로 처리 (예: 뒤로 가기)
                            if (error is ClientError && error.reason == ClientErrorCause.Cancelled) {
                                return@loginWithKakaoTalk
                            }

                            // 카카오톡에 연결된 카카오계정이 없는 경우, 카카오계정으로 로그인 시도
                            UserApiClient.instance.loginWithKakaoAccount(context, callback = callback)
                        } else if (token != null) {
                            Log.i(TAG, "카카오톡으로 로그인 성공 ${token.accessToken}")
                        }
                    }
                } else {
                    UserApiClient.instance.loginWithKakaoAccount(context, callback = callback)
                }*/

            }
        });



    }
    //setOAuthLoginCallback 을 이용을 해서 success가 되었을때 (token이 있을때) 정보를 받아올수있는 객체를
    //사용해서 정보를 얻어오면 된다.

    public void naver_profile(){
        //NidOAuthLogin().callProfileApi(nidProfileCallback) Kotiln
        NidOAuthLogin authLogin = new NidOAuthLogin();
        authLogin.callProfileApi(new NidProfileCallback<NidProfileResponse>() {
            @Override
            public void onSuccess(NidProfileResponse res) {
                Log.d("프로필", "onSuccess: ");
                Log.d("프로필", "onSuccess: " + res.getProfile().getEmail());
                Log.d("프로필", "onSuccess: " + res.getProfile().getMobile());
                Log.d("프로필", "onSuccess: " + res.getProfile().getName());

                // 소셜로그인했을때 회원가입이 되어있는 소셜계정인지 아닌지를 판단해서
                // 회원가입이되어있으면 => MainActivity
                // 안되어있으면 해당 정보로 => JoinActivity
                login(res.getProfile().getEmail(), null);

                
            }

            @Override
            public void onFailure(int i, @NonNull String s) {
                Log.d("프로필", "onFailure: " + s);
            }

            @Override
            public void onError(int i, @NonNull String s) {
                Log.d("프로필", "onError: " + s);
            }
        });

    }

    public void kakao_profile(){
        UserApiClient.getInstance().me((user, throwable) -> {
            if(throwable != null){
                //오류가 났을때 어떤 오류인지 코드로 줌 KOE + 숫자 ( 단무지가 있음 )
            }else{
                Log.d("카카오", "kakao_profile: " + user.getKakaoAccount().getProfile().getNickname());
                Log.d("카카오", "kakao_profile: " + user.getKakaoAccount().getProfile().getThumbnailImageUrl());
                Log.d("카카오", "kakao_profile: " + user.getKakaoAccount().getEmail());
                Log.d("카카오", "kakao_profile: " + user.getKakaoAccount().getName());
                Log.d("카카오", "kakao_profile: " + user.getKakaoAccount().getPhoneNumber());
            }


            return null;
        });

       /* UserApiClient.getInstance().me(new Function2<User, Throwable, Unit>() {
            @Override
            public Unit invoke(User user, Throwable throwable) {
                return null;
            }
        });*/

    }

    //메소드 안에 바뀌어야 될 부분이 고정되어있으면 재활용이 힘든 메소드
    // => editText로 고정되어있던 부분을 파라메터로 뺴주기만하면 재활용이 가능한 구조가 됨.
    public void login(String emil, String pw){
        CommonConn conn = new CommonConn("login.ad", LoginActivity.this);
        conn.addParams("email", emil);
        conn.addParams("pw", pw);
        conn.excuteConn(new CommonConn.ConnCallback() {
            @Override
            public void onResult(boolean isResult, String data) {
                if (isResult){
                    Log.d("성공", "onResult: 성공" + data);
                    CommonVal.loginInfo = new Gson().fromJson(data, AndMemberVO.class);
                    if (CommonVal.loginInfo==null){
                        Log.d("로그인", "onResult: 아이디 비번 틀림");
                    }
                }
            }
        });

    }

    private void getHashKey(){
        PackageInfo packageInfo = null;
        try {
            packageInfo = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (packageInfo == null)
            Log.e("KeyHash", "KeyHash:null");

        for (Signature signature : packageInfo.signatures) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            } catch (NoSuchAlgorithmException e) {
                Log.e("KeyHash", "Unable to get MessageDigest. signature=" + signature, e);
            }
        }
    }
}