import 'package:flutter/material.dart';

class Soal1 extends StatelessWidget {
  const Soal1({
    Key? key,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        leading: FlutterLogo(),
        title: Text("MobileF"),
        centerTitle: false,
        actions: [
          IconButton(
            onPressed: (){
              print('Click more..');
            },
            icon: Icon(Icons.more_vert),
          ),
        ],
      ),
      body: Center(
        child: Text(
            "Hello World",
            style: TextStyle(
                fontSize: 50
            )),
      ),
    );
  }
}