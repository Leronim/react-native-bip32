import { NativeModules } from 'react-native';

type Bip32Type = {
  sign(seed: string, network: string, path?: string): string;
};

const { Bip32 } = NativeModules;

export default Bip32 as Bip32Type;
