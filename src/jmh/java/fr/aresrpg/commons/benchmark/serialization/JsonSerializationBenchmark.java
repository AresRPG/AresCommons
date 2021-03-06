package fr.aresrpg.commons.benchmark.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.aresrpg.commons.domain.serialization.Serializer;
import fr.aresrpg.commons.infra.serialization.formats.JsonFormat;
import fr.aresrpg.commons.infra.serialization.unsafe.UnsafeSerializationFactory;
import org.boon.json.serializers.impl.JsonSimpleSerializerImpl;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.io.IOException;
import java.io.OutputStream;

@State(Scope.Benchmark)
public class JsonSerializationBenchmark {

	public static class Message{
		private String msg;

		public Message(String msg) {
			this.msg = msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

		public String getMsg() {
			return msg;
		}
	}

	private Message message;
	private ObjectMapper jackson;
	private JsonSimpleSerializerImpl boon;
	private Serializer<Message> ares;

	@Setup(Level.Trial)
	public void setup(){
		message = new Message("Hello! World");
		jackson = new ObjectMapper();
		boon = new JsonSimpleSerializerImpl();
		ares = new UnsafeSerializationFactory().createSerializer(Message.class);
	}

	@Benchmark
	public void boonSerialize(Blackhole bh){
		bh.consume(boon.serialize(message).toString());
	}

	@Benchmark
	public void jacksonSerialize(Blackhole bh) throws JsonProcessingException{
		bh.consume(jackson.writeValueAsString(message));
	}

	@Benchmark
	public void aresSerialize(Blackhole bh) throws IOException {
		ares.serialize(new OutputStream() {
			@Override
			public void write(int i) throws IOException {
				bh.consume(i);
			}

			@Override
			public void write(byte[] bytes, int i, int i1) throws IOException {
				bh.consume(bytes);
			}

			@Override
			public void write(byte[] bytes) throws IOException {
				bh.consume(bytes);
			}
		} , message , JsonFormat.INSTANCE);
	}


}
