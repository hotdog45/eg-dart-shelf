import 'package:flutter/material.dart';
import 'fooderlich_theme.dart';

import 'home.dart';

void main() {
  runApp(const Fooderlich());
}

class Fooderlich extends StatelessWidget {
  const Fooderlich({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    // DO: Create theme
    final theme = FooderlichTheme.dark();
    // DO: Apply Home widget
    return MaterialApp(
      // DO: Add theme
      theme: theme,
      title: 'Fooderlich',
      home: const Home(),
    );
  }
}
