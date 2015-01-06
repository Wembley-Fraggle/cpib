package ch.fhnw.cpib;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import ch.fhnw.lederer.virtualmachine.IVirtualMachine;

public class VirtualMachineFile implements IVirtualMachine {

	private final Writer fileWriter;

//	private IInstruction[] code;

  // stores the data
  //  - stack: index 0 upto sp-1
  //  - heap: index store.length - 1 downto hp+1
//  private Data.IBaseData[] store;

  // heap pointer
  //  - points to the first free location on the heap
  //  - heap grows from store.length - 1 downwards
  private int hp;

	
	public VirtualMachineFile(int heapSize, String path) throws IOException {
		fileWriter = new FileWriter(path);
    hp= heapSize - 1;
	}

	@Override
	public void Alloc(int loc, int size) throws CodeTooSmallError {
		try {
			fileWriter.write("Alloc " + loc + ", " + size + '\n');
			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int BoolInitHeapCell() throws HeapTooSmallError {
		return hp--;
	}

	@Override
	public void BoolInput(int loc, String indicator) throws CodeTooSmallError {
		try {
			fileWriter.write("BoolInput " + loc + ", \"" + indicator + "\"" + '\n');
			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void BoolOutput(int loc, String indicator) throws CodeTooSmallError {
		try {
			fileWriter.write("BoolOutput " + loc + ", \"" + indicator + "\"" + '\n');
			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void Call(int loc, int address) throws CodeTooSmallError {
		try {
			fileWriter.write("Call " + loc + ", " + address + '\n');
			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void CondJump(int loc, int jumpLoc) throws CodeTooSmallError {
		try {
			fileWriter.write("CondJump " + loc + ", " + jumpLoc + '\n');
			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void CopyIn(int loc, int fromAddr, int toAddr)
			throws CodeTooSmallError {
		try {
			fileWriter.write("CopyIn " + loc + ", " + fromAddr + ", " + toAddr + '\n');
			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void CopyOut(int loc, int fromAddr, int toAddr)
			throws CodeTooSmallError {
		try {
			fileWriter.write("CopyOut " + loc + ", " + fromAddr + ", " + toAddr + '\n');
			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void Deref(int loc) throws CodeTooSmallError {
		try {
			fileWriter.write("Deref " + loc + '\n');
			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void Enter(int loc, int size, int extreme) throws CodeTooSmallError {
		try {
			fileWriter.write("Enter " + loc + ", " + size + ", " + extreme + '\n');
			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void Error(int loc, String message) throws CodeTooSmallError {
		try {
			fileWriter.write("Error " + loc + ", \"" + message + "\"" + '\n');
			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int FloatInitHeapCell() throws HeapTooSmallError {
		return hp--;
	}

	@Override
	public void FloatInv(int loc) throws CodeTooSmallError {
		try {
			fileWriter.write("FloatInv " + loc + '\n');
			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void FloatLoad(int loc, float value) throws CodeTooSmallError {
		try {
			fileWriter.write("FloatLoad " + loc + ", " + value + '\n');
			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void IntAdd(int loc) throws CodeTooSmallError {
		try {
			fileWriter.write("IntAdd " + loc + '\n');
			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void IntDiv(int loc) throws CodeTooSmallError {
		try {
			fileWriter.write("IntDiv " + loc + '\n');
			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void IntEQ(int loc) throws CodeTooSmallError {
		try {
			fileWriter.write("IntEQ " + loc + '\n');
			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void IntGE(int loc) throws CodeTooSmallError {
		try {
			fileWriter.write("IntGE " + loc + '\n');
			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void IntGT(int loc) throws CodeTooSmallError {
		try {
			fileWriter.write("IntGT " + loc + '\n');
			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int IntInitHeapCell() throws HeapTooSmallError {
		return hp--;
	}

	@Override
	public void IntInput(int loc, String indicator) throws CodeTooSmallError {
		try {
			fileWriter.write("IntInput " + loc + ", \"" + indicator + "\"" + '\n');
			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void IntInv(int loc) throws CodeTooSmallError {
		try {
			fileWriter.write("IntInv " + loc + '\n');
			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void IntLE(int loc) throws CodeTooSmallError {
		try {
			fileWriter.write("IntLE " + loc + '\n');
			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void IntLT(int loc) throws CodeTooSmallError {
		try {
			fileWriter.write("IntLT " + loc + '\n');
			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void IntLoad(int loc, int value) throws CodeTooSmallError {
		try {
			fileWriter.write("IntLoad " + loc + ", " + value + '\n');
			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void IntMod(int loc) throws CodeTooSmallError {
		try {
			fileWriter.write("IntMod " + loc + '\n');
			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void IntMult(int loc) throws CodeTooSmallError {
		try {
			fileWriter.write("IntMult " + loc + '\n');
			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void IntNE(int loc) throws CodeTooSmallError {
		try {
			fileWriter.write("IntNE " + loc + '\n');
			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void IntOutput(int loc, String indicator) throws CodeTooSmallError {
		try {
			fileWriter.write("IntOutput " + loc + ", \"" + indicator + "\"" + '\n');
			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void IntSub(int loc) throws CodeTooSmallError {
		try {
			fileWriter.write("IntSub " + loc + '\n');
			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void LoadRel(int loc, int address) throws CodeTooSmallError {
		try {
			fileWriter.write("LoadRel " + loc + ", " + address + '\n');
			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void Return(int loc, int size) throws CodeTooSmallError {
		try {
			fileWriter.write("Return " + loc + ", " + size + '\n');
			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void Stop(int loc) throws CodeTooSmallError {
		try {
			fileWriter.write("Stop " + loc + '\n');
			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void Store(int loc) throws CodeTooSmallError {
		try {
			fileWriter.write("Store " + loc + '\n');
			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void UncondJump(int loc, int jumpLoc) throws CodeTooSmallError {
		try {
			fileWriter.write("UncondJump " + loc + ", " + jumpLoc + '\n');
			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void execute() throws ExecutionError {

	}

	@Override
	public boolean readYesNo() throws ExecutionError {
		return false;
	}

}
