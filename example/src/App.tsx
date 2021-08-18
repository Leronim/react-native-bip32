import * as React from 'react';

import { StyleSheet, View, Text } from 'react-native';
import Bip32 from 'react-native-bip32';

export default function App() {
  React.useEffect(() => {
    Bip32.sign('123', '312');
  }, []);

  return (
    <View style={styles.container}>
      <Text>123</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
