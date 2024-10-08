//
//  WebView.swift
//  iosApp
//
//  Created by Santiago Mattiauda on 25/8/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import WebKit

struct NativeWebView: View {
    var body: some View {
        WebView(url: "https://google.com")
    }
}

#Preview {
    NativeWebView()
}

struct WebView: UIViewRepresentable {
 
    let urlString: String
    let webView: WKWebView
    
    init(url:String) {
        urlString = url
        webView = WKWebView(frame: .zero)
      
    }
    
    func makeUIView(context: Context) -> WKWebView {
        return webView
    }
    func updateUIView(_ uiView: WKWebView, context: Context) {
        webView.load(URLRequest(url: URL(string: self.urlString)!))
    }
}
