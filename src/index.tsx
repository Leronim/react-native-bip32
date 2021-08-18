import { NativeModules } from 'react-native';

type Bip32Type = {
  multiply(a: number, b: number): Promise<number>;
};

const { Bip32 } = NativeModules;

export default Bip32 as Bip32Type;
