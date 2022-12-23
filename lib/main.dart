import 'package:flutter/material.dart';

void main() {
  runApp(const MobileF());
}

class MobileF extends StatelessWidget {
  const MobileF({Key? key}) : super(key: key);

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text("MobileF"),
          centerTitle: true,
          backgroundColor: Colors.deepOrange,
        ),
        body: Center(
          child: Container(
            width: 200,
            height: 200,
            color: Colors.black,
            child: ElevatedButton(
              onPressed: (){
                print("Hello World!");
              },
              child: Center(
                child: FlutterLogo(
                  size: 100,
                ),
              ),
            )
          ),
        ),
      ),
    );
  }

}