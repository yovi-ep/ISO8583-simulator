package com.mpc.iso.tcpip;

import java.io.DataInputStream;
import java.io.IOException;

import org.jpos.iso.ISOException;

public interface HeaderConfiguration {
	byte[] sendMessageLength(int len) throws IOException;

	int getMessageLength(DataInputStream serverIn) throws IOException, ISOException;
}