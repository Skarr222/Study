/* eslint-disable react-native/no-inline-styles */
import React from "react";
import {
  ScrollView,
  Text,
  StyleSheet,
  useColorScheme,
  StatusBar,
} from "react-native";
import Greeting from "./src/components/Greeting";
import { SafeAreaProvider } from "react-native-safe-area-context";

function App(): React.JSX.Element {
  const isDarkMode = useColorScheme() === "dark";
  return (
    <SafeAreaProvider>
      <StatusBar barStyle={isDarkMode ? "light-content" : "dark-content"} />
      <ScrollView
        contentContainerStyle={{
          flexGrow: 1,
          justifyContent: "center",
          alignItems: "center",
        }}
        style={styles.container}
      >
        <Text style={styles.title}>Hello React Native!</Text>
        <Text style={styles.subtitle}>with TypeScript 🚀</Text>
        <Greeting name="Oskar" age={25} isVip={true} />
        <Greeting name="Krzysztof" age={30} isVip={false} />
        <Greeting name="Magda" age={25} isVip={true} />
        <Greeting name="Grzegorz" age={25} isVip={true} />
      </ScrollView>
    </SafeAreaProvider>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#f5f5f5",
  },
  title: {
    fontSize: 24,
    fontWeight: "bold",
    color: "#333",
  },
  subtitle: {
    fontSize: 16,
    color: "#666",
    marginTop: 8,
  },
});

export default App;
