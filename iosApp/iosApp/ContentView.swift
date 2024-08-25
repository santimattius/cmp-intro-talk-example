import UIKit
import SwiftUI
import ComposeApp

struct ComposeView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        MainViewControllerKt.MainViewController(nativeViewFactory: IOSNativeView.shared)
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}

class IOSNativeView : NativeViewFactory{
    func createWebView(urlString: String) -> UIViewController {
        let webView = WebView(url: urlString)
        return UIHostingController(rootView: webView)
    }
    
    static let shared = IOSNativeView()
}

struct ContentView: View {
    var body: some View {
        ComposeView()
            .edgesIgnoringSafeArea(.top) // Compose has own keyboard handler
    }
}



