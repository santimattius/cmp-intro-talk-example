import platform.UIKit.UIViewController

interface NativeViewFactory {

    fun createWebView(urlString: String): UIViewController
}